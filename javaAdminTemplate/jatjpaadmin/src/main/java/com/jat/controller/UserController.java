package com.jat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jat.controller.model.TableView;
import com.jat.service.UserService;
import com.jat.util.JsonUtil;
import com.jat.util.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/manager/user/list")
    public String list(@RequestParam Map<String,Object> params) throws JsonProcessingException {
        log.debug("{}",params);
        TableView tableView=userService.list(params);
        String dataJson= JsonUtil.objectToJson(tableView);
        Response response=new Response();
        response.setCode(0);
        response.setMsg("用户列表获取成功！");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/user/add")
    public String add(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        userService.add(params);
        response.setCode(0);
        response.setMsg("用户添加成功！");
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/user/edit")
    public String edit(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        userService.edit(params);
        response.setCode(0);
        response.setMsg("用户修改成功！");
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/user/del")
    public String del(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        userService.del(params);
        response.setCode(0);
        response.setMsg("用户删除成功！");
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/user/changepwd")
    public String changepwd(HttpServletRequest req,@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        userService.changepwd(req,params);
        response.setCode(0);
        response.setMsg("修改密码成功！");
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/user/resetUserPwd")
    public String resetUserPwd(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        userService.resetUserPwd(params);
        response.setCode(0);
        response.setMsg("重置密码成功！");
        log.debug("{}",response);
        return response+"";
    }

}
