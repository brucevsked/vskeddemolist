package com.vsked.service.websocket;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.yeauty.pojo.Session;
import com.vsked.common.SysConstant;

@Service
public class RedisReceiver {

    public void receiveMessage(String message) {
    	try{
        //第三步监听处理类遍历本地websocket会话列表并发送消息
    	System.out.println("第二步ok"+message);
    	message=message.replace("\\", "");
    	
    	String to=message.substring(message.indexOf("to")+5,message.indexOf("type")-3);
    	System.out.println("|"+to+"|");

        for(Map.Entry<String, Session> toDataMap:SysConstant.webSocketSessionMap.entrySet()){
        	if(toDataMap.getKey().equals(to)){
        		toDataMap.getValue().sendText(message);
        		System.out.println("发出消息用户"+to);
        	}
        }   
        
    	}catch(Exception e){
    		System.out.println("解析数据异常");
    		e.printStackTrace();
    	}
    }
    
    
    /*

    public void receiveMessage(String message) {
        try {
            message = message.replace("\\", "");
            message = message.substring(1, message.length() - 1);//修正redis序列化加上的引号问题
            log.info("|" + message + "|");
            Map<String, Object> msgMap = StringTool.jsonToMap(message);
            log.info(msgMap + "|");
            String to = (String) msgMap.get("to");//接收方server客户端发给服务端,alluser发给所有用户,client服务端发给客户端,user发给指定用户
            String from = (String) msgMap.get("from");

            if ("server".equals(to)) {//客户端发送给服务端
                //服务端接收
                Map<String, Object> dataMap = (Map<String, Object>) msgMap.get("data");
                log.info("服务端需要操作" + dataMap);
                String dtype = (String) dataMap.get("dtype");//连接类型,1客户端订阅服务端主题,2客户端取消服务端订阅,3服务端推送给客户端对应主题数据
                String dvalue = (String) dataMap.get("dvalue");//主题
                String[] dataArray = dvalue.split(",");
                boolean isExistTopic = false;
                boolean isExistSub = false;
                String redisData = "";
                String[] redisDataArray;
                List<String> myTmpList = new LinkedList<>();
                if ("1".equals(dtype)) { //1客户端订阅服务端主题
                    for (String data : dataArray) {
                        //判断redis中是否有这个主题
                        isExistTopic = redisTemplate.opsForHash().hasKey(SysConstant.webSocketTopicToken, data);
                        if (!isExistTopic) {
                            //不存在直接添加
                            redisTemplate.opsForHash().put(SysConstant.webSocketTopicToken, data, from);
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
                        //判断redis中是否有这个主题
                        isExistTopic = redisTemplate.opsForHash().hasKey(SysConstant.webSocketTopicToken, data);
                        if (isExistTopic) {  //存在这个主题
                            redisData = (String) redisTemplate.opsForHash().get(SysConstant.webSocketTopicToken, data); //取出原来的主题token列表
                            redisDataArray = redisData.split(",");
                            myTmpList = new LinkedList<>(Arrays.asList(redisDataArray));
                            Iterator<String> iterator = myTmpList.iterator();
                            while (iterator.hasNext()) {
                                String oldToken = iterator.next();
                                for (Map.Entry<String, Session> toDataMap : SysConstant.webSocketSessionMap.entrySet()) {
                                    log.info("token1:" + toDataMap.getKey());
                                    log.info("token2:" + oldToken);
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
        }
    }
    
    */
}
