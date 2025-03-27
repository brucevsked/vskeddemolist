package com.jat.service;

import com.jat.controller.model.MenuView;
import com.jat.controller.model.ResourceAddEditResourceView;
import com.jat.controller.model.ResourceListResourceView;
import com.jat.controller.model.TableView;
import com.jat.repository.ResourceRepository;
import com.jat.repository.model.ResourcePO;
import com.jat.repository.specific.ResourceListSpecific;
import com.jat.system.model.resource.Resource;
import com.jat.system.model.resource.ResourceIcon;
import com.jat.system.model.resource.ResourceId;
import com.jat.system.model.resource.ResourceName;
import com.jat.system.model.resource.ResourceSequence;
import com.jat.system.model.resource.ResourceType;
import com.jat.system.model.resource.ResourceUrl;
import com.jat.util.MenuTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ResourceService extends BaseService{
    private static final Logger log = LoggerFactory.getLogger(ResourceService.class);

    @Autowired
    PageService pageService;
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    RoleResourceService roleResourceService;

    public TableView list(Map<String,Object> params) {
        PageService pageService1 = pageService.getPage(params);
        log.debug("{}", pageService1);
        params.put("isDel",0);
        log.debug("{}", params);
        Pageable pageable = PageRequest.of(pageService1.getPageIndex(), pageService1.getPageSize());

        Specification specification=new ResourceListSpecific(params);

        Page<ResourcePO> resourcePage=resourceRepository.findAll(specification,pageable);

        List<ResourcePO> resources=resourcePage.getContent();

        log.debug("{}", resources);

        List<ResourceListResourceView> resourceList=new LinkedList<>();
        for(ResourcePO po:resources){
            ResourceListResourceView resourceListResourceView=new ResourceListResourceView();
            resourceListResourceView.setId(po.getId());
            resourceListResourceView.setName(po.getName());
            resourceListResourceView.setUrl(po.getUrl());
            resourceListResourceView.setIcon(po.getIcon());
            resourceListResourceView.setType(po.getType());
            resourceListResourceView.setSequence(po.getSequence());
            resourceListResourceView.setParentName(po.getParent()==null?"":po.getParent().getName());
            resourceList.add(resourceListResourceView);
        }
        return new TableView(resourcePage.getTotalElements(),resourceList);
    }

    public void add(Map<String,Object> params){
        String nameStr=getStr(params.get("name"));
        String urlStr=getStr(params.get("url"));
        String icoStr=getStr(params.get("icon"));
        String typeStr=getStr(params.get("type"));
        Integer sequenceInt=getInt(params.get("sequence"));
        Integer parentIdInt=getInt(params.get("parentId"));

        log.debug("{},{},{},{},{},{}",nameStr,urlStr,icoStr,typeStr,sequenceInt,parentIdInt);
        ResourceName resourceName=new ResourceName(nameStr);
        ResourceUrl resourceUrl=new ResourceUrl(urlStr);
        ResourceIcon resourceIcon=new ResourceIcon(icoStr);
        ResourceType resourceType=new ResourceType(typeStr);
        ResourceSequence resourceSequence=new ResourceSequence(sequenceInt);
        ResourcePO parentPo=findBy(parentIdInt);
        Resource parent=Resource.poToBo(parentPo);
        Resource resourceAdd=new Resource(resourceName,resourceUrl,resourceIcon,resourceType,resourceSequence,parent);

        ResourcePO resourcePOAdd=resourceAdd.boToPo(0);

        resourcePOAdd=resourceRepository.save(resourcePOAdd);
        log.debug("{}", resourcePOAdd);
    }


    public void edit(Map<String,Object> params){
        Integer idInt=getInt(params.get("id"));
        String nameStr=getStr(params.get("name"));
        String urlStr=getStr(params.get("url"));
        String iconStr=getStr(params.get("icon"));
        String typeStr=getStr(params.get("type"));
        Integer sequenceInt=getInt(params.get("sequence"));
        Integer parentIdInt=getInt(params.get("parentId"));

        log.debug("{},{},{},{},{},{}",nameStr,urlStr,iconStr,typeStr,sequenceInt,parentIdInt);
        ResourceId resourceId=new ResourceId(idInt);
        ResourceName resourceName=new ResourceName(nameStr);
        ResourceUrl resourceUrl=new ResourceUrl(urlStr);
        ResourceIcon resourceIcon=new ResourceIcon(iconStr);
        ResourceType resourceType=new ResourceType(typeStr);
        ResourceSequence resourceSequence=new ResourceSequence(sequenceInt);
        ResourcePO parentPo=findBy(parentIdInt);
        Resource parent=Resource.poToBo(parentPo);
        Resource resourceEdit=new Resource(resourceId,resourceName,resourceUrl,resourceIcon,resourceType,resourceSequence,parent);

        ResourcePO resourcePOEdit=resourceEdit.boToPo(0);

        resourcePOEdit=resourceRepository.save(resourcePOEdit);
        log.debug("{}", resourcePOEdit);
    }

    public List<MenuView> findAllMenus(){
        Integer isDel=0;
        List<ResourcePO> pos=resourceRepository.findAllByIsDelIsOrderBySequenceAsc(isDel);
        List<MenuView> menuViews= MenuTool.resourceToMenu(pos);
        log.debug("{}", menuViews);
        return menuViews;
    }

    public List<ResourceAddEditResourceView> findAllResource(){
        Integer isDel=0;
        List<ResourcePO> pos=resourceRepository.findAllByIsDelIsOrderBySequenceAsc(isDel);
        List<ResourceAddEditResourceView> resourceViews= new LinkedList<>();
        for(ResourcePO po:pos){
            ResourceAddEditResourceView view=new ResourceAddEditResourceView();
            view.setId(po.getId());
            view.setName(po.getName());
            resourceViews.add(view);
        }
        log.debug("{}", resourceViews);
        return resourceViews;
    }

    public ResourceAddEditResourceView findResourceBy(Map<String,Object> params){
        Integer idInt=getInt(params.get("id"));
        ResourceId resourceId=new ResourceId(idInt);
        ResourcePO po=findBy(resourceId.getId());
        return po==null?null:new ResourceAddEditResourceView(po.getId(),po.getName(),po.getUrl(),po.getIcon(),po.getType(),po.getSequence(),po.getParentId());
    }

    public List<ResourcePO> findAllBy(List<Integer> ids){
        return resourceRepository.findAllById(ids);
    }

    public ResourcePO findById(List<ResourcePO> resrouces,Integer id){
        ResourcePO resourcePO=null;
        for(ResourcePO po:resrouces){
            if(id==po.getId()){
                resourcePO=po;
                return resourcePO;
            }
        }
        return resourcePO;
    }

    public ResourcePO findBy(Integer id){
        return resourceRepository.findById(id).orElse(null);
    }

    public void del(Map<String,Object> params){
        Integer idInt=getInt(params.get("id"));
        log.debug("{}",idInt);
        ResourceId resourceId=new ResourceId(idInt);

        ResourcePO po=resourceRepository.findById(resourceId.getId()).orElse(null);
        po.setIsDel(1);//删除标记
        resourceRepository.save(po);//菜单
        roleResourceService.updateIsDelByResId(resourceId.getId()); //角色菜单

    }

}
