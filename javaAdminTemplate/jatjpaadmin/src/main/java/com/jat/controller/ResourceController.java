package com.jat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jat.controller.model.ResourceAddEditResourceView;
import com.jat.controller.model.TableView;
import com.jat.service.ResourceService;
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
public class ResourceController {
    private static final Logger log = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    ResourceService resourceService;

    @GetMapping("/manager/resource/findAll")
    public String findAll() throws JsonProcessingException {
        log.trace("findAll");
        Response response = new Response();
        List<ResourceAddEditResourceView> views=resourceService.findAllResource();
        String dataJson= JsonUtil.objectToJson(views);
        response.setCode(0);
        response.setMsg("资源列表获取成功！");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

    @GetMapping("/manager/resource/findById")
    public String findById(@RequestParam Map<String,Object> params) throws JsonProcessingException {
        log.debug("{}",params);
        ResourceAddEditResourceView resourceView=resourceService.findResourceBy(params);
        String dataJson= JsonUtil.objectToJson(resourceView);
        Response response=new Response();
        response.setCode(0);
        response.setMsg("资源获取成功！");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

    @GetMapping("/manager/resource/list")
    public String list(@RequestParam Map<String,Object> params) throws JsonProcessingException {
        log.debug("{}",params);
        TableView tableView=resourceService.list(params);
        String dataJson= JsonUtil.objectToJson(tableView);
        Response response=new Response();
        response.setCode(0);
        response.setMsg("资源列表获取成功！");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/resource/add")
    public String add(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        resourceService.add(params);
        response.setCode(0);
        response.setMsg("资源添加成功！");
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/resource/edit")
    public String edit(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        resourceService.edit(params);
        response.setCode(0);
        response.setMsg("资源修改成功！");
        log.debug("{}",response);
        return response+"";
    }

    @Transactional
    @PostMapping("/manager/resource/del")
    public String del(@RequestBody Map<String,Object> params){
        log.debug("{}",params);
        Response response=new Response();
        resourceService.del(params);
        response.setCode(0);
        response.setMsg("资源删除成功！");
        log.debug("{}",response);
        return response+"";
    }
}
