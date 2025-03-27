package com.jat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jat.controller.model.RoleListRoleView;
import com.jat.controller.model.TableView;
import com.jat.service.RoleService;
import com.jat.util.JsonUtil;
import com.jat.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleService roleService;

    @GetMapping("/manager/user/findAllRole")
    public String findAllRole() throws JsonProcessingException {
        log.trace("findAllRole");
        List<RoleListRoleView> roles=roleService.findAllRole();
        String dataJson= JsonUtil.objectToJson(roles);
        Response response=new Response();
        response.setCode(0);
        response.setMsg("所有角色获取成功！");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

    @GetMapping("/manager/role/list")
    public String list(@RequestParam Map<String,Object> params) throws JsonProcessingException {
        log.debug("{}",params);
        TableView tableView=roleService.list(params);
        String dataJson= JsonUtil.objectToJson(tableView);
        Response response=new Response();
        response.setCode(0);
        response.setMsg("角色列表获取成功！");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/role/add")
    public String add(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        roleService.add(params);
        response.setCode(0);
        response.setMsg("角色添加成功！");
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/role/edit")
    public String edit(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        roleService.edit(params);
        response.setCode(0);
        response.setMsg("角色修改成功！");
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/role/del")
    public String del(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        roleService.del(params);
        response.setCode(0);
        response.setMsg("角色删除成功！");
        log.debug("{}",response);
        return response+"";
    }


}
