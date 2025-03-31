package com.jat.service;

import com.jat.config.JwtKit;
import com.jat.controller.model.MenuView;
import com.jat.controller.model.RoleAddEditResourceView;
import com.jat.repository.RoleResourceRepository;
import com.jat.repository.model.ResourcePO;
import com.jat.repository.model.RoleResourcePO;
import com.jat.system.model.role.RoleId;
import com.jat.system.model.user.UserId;
import com.jat.util.MenuTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class RoleResourceService extends BaseService{
    private static final Logger log = LoggerFactory.getLogger(RoleResourceService.class);

    @Autowired
    RoleResourceRepository roleResourceRepository;
    @Autowired
    UserRoleService userRoleService;

    @Autowired
    JwtKit jwtKit;

    public List<RoleResourcePO> findBy(List<Integer> roleIds){
        return roleResourceRepository.findByRoleIdInOrderByResourceSequenceAsc(roleIds);
    }

    public List<RoleResourcePO> findBy(RoleId roleId){
        return roleResourceRepository.findByRoleId(roleId.getId());
    }

    public List<RoleAddEditResourceView> findResourcesBy(RoleId roleId){
        List<RoleResourcePO> roleResources=findBy(roleId);
        List<RoleAddEditResourceView> roleAddEditResourceViews=new LinkedList<>();
        for(RoleResourcePO roleResourcePO:roleResources){
            RoleAddEditResourceView roleAddEditResourceView=new RoleAddEditResourceView(roleResourcePO.getId().getResId());
            roleAddEditResourceViews.add(roleAddEditResourceView);
        }
        return roleAddEditResourceViews;
    }

    public List<RoleAddEditResourceView> findResourcesBy(Map<String,Object> params){
        Integer roleIdInt=getInt(params.get("id"));
        RoleId roleId=new RoleId(roleIdInt);
        return findResourcesBy(roleId);
    }


    public List<ResourcePO> findResourcesBy(List<Integer> roleIds){
        List<ResourcePO> resources=new LinkedList<>();
        List<RoleResourcePO> roleResources=findBy(roleIds);
        for(RoleResourcePO roleResource:roleResources){
            ResourcePO resourcePO=roleResource.getResource();
            if(!resources.contains(resourcePO)){
                resources.add(resourcePO);
            }
        }
        log.debug("{}",resources);
        return resources;
    }

    public List<MenuView> findMenuBy(List<Integer> roleIds){
        List<ResourcePO> resources=findResourcesBy(roleIds);
        return MenuTool.resourceToMenu(resources);
    }

    public List<MenuView> findRoleMenus(HttpServletRequest req){
        Integer userId=jwtKit.getJwtUserIdBy(req);
        log.debug("{}",userId);
        List<Integer> roleIds=userRoleService.findRoleIdsBy(new UserId(userId));
        log.debug("{}",roleIds);
        List<MenuView> menuViews=findMenuBy(roleIds);
        log.debug("{}",menuViews);
        return menuViews;

    }

    public void deleteBy(RoleId roleId){
        roleResourceRepository.deleteByRoleId(roleId.getId());
    }

    public void updateIsDelByRoleId(Integer roleId){
        roleResourceRepository.updateIsDelByRoleId(roleId);
    }

    public void updateIsDelByResId(Integer resId){
        roleResourceRepository.updateIsDelByResId(resId);
    }


}
