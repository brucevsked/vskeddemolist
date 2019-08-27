package com.vsked.service;

import com.vsked.common.*;
import com.vsked.dao.SysUserDao;
import com.vsked.shiro.JwtUtil;
import com.vsked.shiro.Token;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@Transactional
public class SysUserService extends BaseService{

    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public String sysUserLogin(HttpServletRequest req, HttpServletResponse res){
        String result="";
        try{
            log.info("start login");
            Map<String, Object> reqDataMap=getMaps(req);
            log.info(reqDataMap+"");
            String sysusername=(String) reqDataMap.get("sysusername");
            String sysuserpwd=(String) reqDataMap.get("sysuserpwd");
            if(StringTool.isBlank(sysusername)){
                return RequestResponseTool.getJsonMessage(RespCode.noPhone, RespMsg.noPhone);
            }

            if(StringTool.isBlank(sysuserpwd)){
                return RequestResponseTool.getJsonMessage(RespCode.noUserPass, RespMsg.noUserPass);
            }
            sysuserpwd= CryptoTool.md5(sysuserpwd);
            sysuserpwd=sysuserpwd.toLowerCase();
            Map<String, Object> userMap=sysUserDao.getSysUserByUserName(sysusername);

            if(userMap==null){
                result=RequestResponseTool.getJsonMessage(RespCode.userNotExist, RespMsg.userNotExist);
                return result;
            }

            if(sysuserpwd.equals(userMap.get("sysuserpwd"))){

                userMap.remove("salt");
                userMap.remove("userpass");

                String oldToken=(String) redisTemplate.opsForValue().get(SysConstant.REDIS_TOKEN + sysusername);
                if(!StringTool.isBlank(oldToken)){
                    redisTemplate.delete(oldToken);//del old token
                }
                redisTemplate.delete(SysConstant.REDIS_TOKEN + sysusername);//del old key

                String token= JwtUtil.create(StringTool.mapToJson(JwtUtil.procTokenMap(userMap)));
                res.setHeader("token", token);
                Token myToken=new Token(token);
                Subject userSubject= SecurityUtils.getSubject();
                userSubject.login(myToken);

                redisTemplate.opsForValue().set(SysConstant.REDIS_TOKEN + sysusername, token, SysConstant.EXPIRE_TIME * 2, TimeUnit.SECONDS);
                redisTemplate.opsForValue().set(token,sysusername, SysConstant.EXPIRE_TIME * 2, TimeUnit.SECONDS);
//		redisTemplate.persist(SysConstant.REDIS_TOKEN + phone);//永不过期

                Map<String, String> respDataMap=new HashMap<String, String>();
                respDataMap.put("token", token);
                String data=StringTool.mapToJson1(respDataMap);
                result=RequestResponseTool.getJsonMessage(RespCode.authJwtSucc, RespMsg.authJwtSucc, data);
            }else{
                result=RequestResponseTool.getJsonMessage(RespCode.authPassFail, RespMsg.authPassFail);
            }
        }catch(Exception e){
            rollBack(e, log);
            result=RequestResponseTool.getJsonMessage(RespCode.loginException, RespMsg.loginException+e.getMessage());
        }
        return result;
    }

    public String list(){
        String result="";
        try{
            System.out.println("hallo ----------------");
            result= StringTool.listToJson(sysUserDao.list());
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return result;
    }

    public String add(){
        String result="";
        try{
           Map<String,Object> dataMap=new HashMap<>();
            dataMap.put("right","当前你有权");
            dataMap.put("method","这里叫添加");
            result=StringTool.mapToJson(dataMap);
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return result;
    }
    public String edit(){
        String result="";
        try{
            Map<String,Object> dataMap=new HashMap<>();
            dataMap.put("right","当前你有权");
            dataMap.put("method","这里叫修改");
            result=StringTool.mapToJson(dataMap);
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return result;
    }
    public String del(){
        String result="";
        try{
            Map<String,Object> dataMap=new HashMap<>();
            dataMap.put("right","当前你有权");
            dataMap.put("method","这里叫删除");
            result=StringTool.mapToJson(dataMap);
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return result;
    }
}
