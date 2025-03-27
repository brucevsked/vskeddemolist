package com.jat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jat.controller.model.RoleListRoleView;
import com.jat.service.UserRoleService;
import com.jat.util.JsonUtil;
import com.jat.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class UserRoleController {
    private static final Logger log = LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/manager/user/findUserRole")
    public String findUserRole(@RequestParam Map<String,Object> params) throws JsonProcessingException {
        log.debug("{}", params);
        List<RoleListRoleView> roles=userRoleService.findRoleByUserId(params);
        String dataJson= JsonUtil.objectToJson(roles);
        Response response=new Response();
        response.setCode(0);
        response.setMsg("用户角色获取成功！");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

}
