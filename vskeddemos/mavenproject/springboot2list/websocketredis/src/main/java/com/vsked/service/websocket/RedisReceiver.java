package com.jcdz.hbdservice.websocket;

import java.util.*;

import com.jcdz.hcommon.DateTimeTool;
import com.jcdz.hcommon.StringTool;
import com.jcdz.hcommon.SysConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.yeauty.pojo.Session;

/**
 * websocket连接异常代码
 * 0000 成功
 * 0001 服务端无此主题
 * 0002 服务端异常
 */
@Slf4j
@Service
public class RedisReceiver {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void receiveMessage(String message)  {
        String from="";
        String curTopic="";//当前处理的主题
        try {
            message = message.replace("\\", "");
            message = message.substring(1, message.length() - 1);//修正redis序列化加上的引号问题
            log.info("|" + message + "|");
            Map<String, Object> msgMap = StringTool.jsonToMap(message);
            log.info(msgMap + "|");
            String to = (String) msgMap.get("to");//接收方server客户端发给服务端,alluser发给所有用户,client服务端发给客户端,user发给指定用户
            from = (String) msgMap.get("from");

            if ("server".equals(to)) {//客户端发送给服务端
                //服务端接收
                Map<String, Object> dataMap = (Map<String, Object>) msgMap.get("data");
                log.info("服务端需要操作" + dataMap);
                String dtype = (String) dataMap.get("dtype");//连接类型,1客户端订阅服务端主题,2客户端取消服务端订阅,3服务端推送给客户端对应主题数据,4心跳连接
                String dvalue = (String) dataMap.get("dvalue");//主题
                String[] dataArray = dvalue.split(",");
                boolean isExistTopic = false;
                boolean isExistSub = false;
                String redisData = "";
                String[] redisDataArray;
                List<String> myTmpList = new LinkedList<>();
                if ("1".equals(dtype)) { //1客户端订阅服务端主题
                    for (String data : dataArray) {
                        curTopic=data;
                        //判断redis中是否有这个主题
                        isExistTopic = redisTemplate.opsForHash().hasKey(SysConstant.webSocketTopicToken, data);
                        if (!isExistTopic) {
                            //不存在发送消息给客户端不存在此主题
                            //拼装数据
                            Map<String,Object> clientDataMap=new HashMap<>();
                            clientDataMap.put("dtype","3");//数据类型,1数据订阅,2取消订阅,3订阅数据
                            clientDataMap.put("dvalue",data);//订阅主题
                            List<Map<String,Object>> errorDataList=new LinkedList<>();
                            Map<String,Object> errorMsgMap=new HashMap<>();
                            errorMsgMap.put("msg","没有这个主题请检查api:http://127.0.0.1:9110/websocket/getTopicList");
                            errorDataList.add(errorMsgMap);
                            clientDataMap.put("ddata",errorDataList);
                            //拼装消息Map
                            Map<String,Object> msgTemplateMap=new HashMap<>();
                            msgTemplateMap.put("code","0001");//成功时0000失败时用其他代码
                            msgTemplateMap.put("from","server");//server服务端发出,token用户端发出
                            msgTemplateMap.put("to","client");//server发给服务端,alluser发给所有用户,client发给客户端,user发给指定用户
                            msgTemplateMap.put("type","3");//类型,1用户对用户2用户对服务器3服务器对用户 暂未使用
                            msgTemplateMap.put("time", DateTimeTool.getCurDateTime(DateTimeTool.format3));//发送时间预留字段yyyyMMddHHmmssSSS
                            msgTemplateMap.put("data",clientDataMap);
                            message=StringTool.mapToJson(msgTemplateMap);
                            //给单个用户发
                            for (Map.Entry<String, Session> toDataMap : SysConstant.webSocketSessionMap.entrySet()) {
                                if (toDataMap.getKey().equals(from)) {
                                    toDataMap.getValue().sendText(message);
                                }
                            }
                        } else {
                            //取出原来的主题token列表
                            redisData = (String) redisTemplate.opsForHash().get(SysConstant.webSocketTopicToken, data);
                            redisDataArray = redisData.split(",");

                            isExistSub = false;
                            for (String redisDataTmp : redisDataArray) {
                                if (from.equals(redisDataTmp)) {
                                    isExistSub = true;//已经存在订阅不处理
                                }
                            }
                            if (!isExistSub) {
                                //不存在就添加到redis订阅中
                                myTmpList = new LinkedList<>(Arrays.asList(redisDataArray));
                                myTmpList.add(from);
                                StringBuilder stringBuilder = new StringBuilder();
                                for (String myTmp : myTmpList) {
                                    stringBuilder.append(myTmp + ",");
                                }
                                stringBuilder.setLength(stringBuilder.length() - 1);
                                redisTemplate.opsForHash().put(SysConstant.webSocketTopicToken, data, stringBuilder.toString());
                            }
                        }

                    }

                } else if ("2".equals(dtype)) { //2客户端取消服务端订阅
                    for (String data : dataArray) {
                        curTopic=data;
                        //判断redis中是否有这个主题
                        isExistTopic = redisTemplate.opsForHash().hasKey(SysConstant.webSocketTopicToken, data);
                        if (isExistTopic) {
                            //存在这个主题
                            //取出原来的主题token列表
                            redisData = (String) redisTemplate.opsForHash().get(SysConstant.webSocketTopicToken, data);
                            redisDataArray = redisData.split(",");
                            myTmpList = new LinkedList<>(Arrays.asList(redisDataArray));
                            Iterator<String> iterator = myTmpList.iterator();
                            while (iterator.hasNext()) {
                                String oldToken = iterator.next();
                                if (oldToken.equals(from)) {
                                    iterator.remove();
                                }
                            }

                            if (myTmpList.size() == 0) {
                                redisTemplate.opsForHash().delete(SysConstant.webSocketTopicToken, data);//删除这个主题
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (String myTmp : myTmpList) {
                                    stringBuilder.append(myTmp + ",");
                                }
                                stringBuilder.setLength(stringBuilder.length() - 1);
                                redisTemplate.opsForHash().put(SysConstant.webSocketTopicToken, data, stringBuilder.toString());//放入新订阅列表
                            }
                        }
                    }
                }else if("4".equals(dtype)){
                    Map<String,Object> clientDataMap=new HashMap<>();
                    clientDataMap.put("dtype","3");//数据类型,1数据订阅,2取消订阅,3订阅数据
                    clientDataMap.put("dvalue","pong");//订阅主题
                    List<Map<String,Object>> errorDataList=new LinkedList<>();
                    Map<String,Object> errorMsgMap=new HashMap<>();
                    errorMsgMap.put("msg","pong");
                    errorDataList.add(errorMsgMap);
                    clientDataMap.put("ddata",errorDataList);
                    //拼装消息Map
                    Map<String,Object> msgTemplateMap=new HashMap<>();
                    msgTemplateMap.put("code","0000");//成功时0000失败时用其他代码
                    msgTemplateMap.put("from","server"); //server服务端发出,token用户端发出
                    msgTemplateMap.put("to","client");//server发给服务端,alluser发给所有用户,client发给客户端,user发给指定用户
                    msgTemplateMap.put("type","3");//类型,1用户对用户2用户对服务器3服务器对用户 暂未使用
                    msgTemplateMap.put("time", DateTimeTool.getCurDateTime(DateTimeTool.format3));//发送时间预留字段yyyyMMddHHmmssSSS
                    msgTemplateMap.put("data",clientDataMap);
                    message=StringTool.mapToJson(msgTemplateMap);
                    //给单个用户发
                    for (Map.Entry<String, Session> toDataMap : SysConstant.webSocketSessionMap.entrySet()) {
                        if (toDataMap.getKey().equals(from)) {
                            toDataMap.getValue().sendText(message);
                        }
                    }
                }

            } else if ("alluser".equals(to)) {
                //给所有用户发
                for (Map.Entry<String, Session> toDataMap : SysConstant.webSocketSessionMap.entrySet()) {
                    toDataMap.getValue().sendText(message);
                }
            } else if ("client".equals(to)) {
                log.info("-------------服务端发送给客户端数据-------------");
                //客户端接收
                Map<String, Object> dataMap = (Map<String, Object>) msgMap.get("data");
                log.info("服务端需要操作" + dataMap);
                String dtype = (String) dataMap.get("dtype");//连接类型,1客户端订阅服务端主题,2客户端取消服务端订阅,3服务端推送给客户端对应主题数据
                String dvalue = (String) dataMap.get("dvalue");//主题
                log.info("当前主题|" + dvalue);
                String[] dataArray = dvalue.split(",");
                boolean isExistTopic = false;
                String redisData = "";
                String[] redisDataArray;
                List<String> myTmpList = new LinkedList<>();
                if ("3".equals(dtype)) {
                    //向客户端发送订阅数据
                    for (String data : dataArray) {
                        curTopic=data;
                        //判断redis中是否有这个主题
                        isExistTopic = redisTemplate.opsForHash().hasKey(SysConstant.webSocketTopicToken, data);
                        if (!isExistTopic) {
                            log.debug("redis里没有这个主题,要进行创建"+data);
                            //不存在这个主题直接添加
                            redisTemplate.opsForHash().put(SysConstant.webSocketTopicToken, data, "");
                        }
                        if (isExistTopic) {  //存在这个主题
                            redisData = (String) redisTemplate.opsForHash().get(SysConstant.webSocketTopicToken, data); //取出原来的主题token列表
                            redisDataArray = redisData.split(",");
                            myTmpList = new LinkedList<>(Arrays.asList(redisDataArray));
                            Iterator<String> iterator = myTmpList.iterator();
                            while (iterator.hasNext()) {
                                String oldToken = iterator.next();
                                for (Map.Entry<String, Session> toDataMap : SysConstant.webSocketSessionMap.entrySet()) {
                                    if (toDataMap.getKey().equals(oldToken)) {
                                        toDataMap.getValue().sendText(message); //发送消息给用户
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                //给单个用户发
                for (Map.Entry<String, Session> toDataMap : SysConstant.webSocketSessionMap.entrySet()) {
                    if (toDataMap.getKey().equals(to)) {
                        toDataMap.getValue().sendText(message);
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                Map<String, Object> clientDataMap = new HashMap<>();
                clientDataMap.put("dtype", "3");//数据类型,1数据订阅,2取消订阅,3订阅数据
                clientDataMap.put("dvalue", curTopic);//订阅主题
                List<Map<String, Object>> errorDataList = new LinkedList<>();
                Map<String, Object> errorMsgMap = new HashMap<>();
                errorMsgMap.put("msg", "服务端发生异常请联系管理员:" + e.getMessage());
                errorDataList.add(errorMsgMap);
                clientDataMap.put("ddata", errorDataList);
                //拼装消息Map
                Map<String, Object> msgTemplateMap = new HashMap<>();
                msgTemplateMap.put("code", "0002");//成功时0000失败时用其他代码
                msgTemplateMap.put("from", "server");//server服务端发出,token用户端发出
                msgTemplateMap.put("to", "client");//server发给服务端,alluser发给所有用户,client发给客户端,user发给指定用户
                msgTemplateMap.put("type", "3");//类型,1用户对用户2用户对服务器3服务器对用户 暂未使用
                msgTemplateMap.put("time", DateTimeTool.getCurDateTime(DateTimeTool.format3));//发送时间预留字段yyyyMMddHHmmssSSS
                msgTemplateMap.put("data", clientDataMap);
                message = StringTool.mapToJson(msgTemplateMap);
                //给单个用户发
                for (Map.Entry<String, Session> toDataMap : SysConstant.webSocketSessionMap.entrySet()) {
                    if (toDataMap.getKey().equals(from)) {
                        toDataMap.getValue().sendText(message);
                    }
                }
            }catch(Exception e1){
                log.error(e1.getMessage(), e1);
            }
        }
    }
}
