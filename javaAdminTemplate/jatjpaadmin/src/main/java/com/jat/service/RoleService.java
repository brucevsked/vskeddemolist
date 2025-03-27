package com.jat.service;

import com.jat.controller.model.RoleListRoleView;
import com.jat.controller.model.TableView;
import com.jat.repository.RoleRepository;
import com.jat.repository.RoleResourceRepository;
import com.jat.repository.model.ResourcePO;
import com.jat.repository.model.RolePO;
import com.jat.repository.model.RoleResourcePO;
import com.jat.system.model.role.Role;
import com.jat.system.model.role.RoleDescript;
import com.jat.system.model.role.RoleId;
import com.jat.system.model.role.RoleName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class RoleService extends BaseService{

    private static final Logger log = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    PageService pageService;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleResourceRepository roleResourceRepository;
    @Autowired
    ResourceService resourceService;
    @Autowired
    RoleResourceService roleResourceService;
    @Autowired
    UserRoleService userRoleService;

    public List<RoleListRoleView> findAllRole(){
        List<RoleListRoleView> roles=new LinkedList<>();
        Integer isDel=0;
        List<RolePO> pos=roleRepository.findAllByIsDelIsOrderByIdAsc(isDel);
        for(RolePO po:pos){
            RoleListRoleView roleView=new RoleListRoleView();
            roleView.setId(po.getId());
            roleView.setName(po.getName());
            roles.add(roleView);
        }
        return roles;
    }

    public List<Role> findRolesById(List<Integer> roleIds){
        List<RolePO> rolePos=roleRepository.findAllById(roleIds);
        List<Role> roles=new LinkedList<>();
        for(RolePO po:rolePos){
            roles.add(Role.poToBo(po));
        }
        return roles;
    }


    public List<RolePO> findAllById(List<Integer> roleIds){
        return roleRepository.findAllById(roleIds);
    }

    public RolePO findById(List<RolePO> pos,Integer roleId){
        RolePO rolePo=null;
        for(RolePO po:pos){
            if(roleId==po.getId()){
                rolePo=po;
                return rolePo;
            }
        }
        return rolePo;
    }

    public Role findRoleById(List<Role> roles,Integer roleId){
        Role role=null;
        for(Role r:roles){
            if(roleId==r.getId().getId()){
                role=r;
                return role;
            }
        }
        return role;
    }

    public TableView list(Map<String,Object> params){
        PageService pageService1=pageService.getPage(params);
        log.debug("{}",pageService1);
        String name=pageService.getLike(params.get("name"));
        Integer isDel=0;
        Pageable pageable= PageRequest.of(pageService1.getPageIndex(),pageService1.getPageSize());

        Page<RolePO> pageData=roleRepository.findByNameLikeAndIsDelIs(name,isDel,pageable);
        List<RolePO> roles=pageData.getContent();
        List<RoleListRoleView> roleViewList=new LinkedList<>();
        for(RolePO po:roles){
            RoleListRoleView roleView=new RoleListRoleView();
            roleView.setId(po.getId());
            roleView.setName(po.getName());
            roleView.setDescript(po.getDescript());
            roleViewList.add(roleView);
        }

        return new TableView(pageData.getTotalElements(),roleViewList);
    }

    public void add(Map<String,Object> params){
        String roleNameStr=getStr(params.get("name"));
        String roleDescriptStr=getStr(params.get("descript"));
        List<Integer> menuIdsIntList=getIntList(params.get("menuIds"));

        log.debug("{},{},{}",roleNameStr,roleDescriptStr,menuIdsIntList);
        RoleName roleName=new RoleName(roleNameStr);
        RoleDescript roleDescript=new RoleDescript(roleDescriptStr);
        Role roleAdd=new Role(roleName,roleDescript);

        RolePO rolePO=new RolePO(roleAdd.getName().getName(),roleAdd.getDescript().getDescript());

        rolePO=roleRepository.save(rolePO);//保存将ID返回来

        List<RoleResourcePO> roleResources=new LinkedList<>();
        List<ResourcePO> resources=resourceService.findAllBy(menuIdsIntList);

        for(Integer rid:menuIdsIntList){
            ResourcePO resourcePo=resourceService.findById(resources,rid);
            RoleResourcePO roleResourcePO=new RoleResourcePO(rolePO,resourcePo,0);
            roleResources.add(roleResourcePO);
        }
        roleResourceRepository.saveAll(roleResources);
    }

    public void edit(Map<String,Object> params){
        Integer roleIdInt=getInt(params.get("id"));
        String roleNameStr=getStr(params.get("name"));
        String roleDescriptStr=getStr(params.get("descript"));
        List<Integer> menuIdsIntList=getIntList(params.get("menuIds"));

        log.debug("{},{},{},{}",roleIdInt,roleNameStr,roleDescriptStr,menuIdsIntList);
        RoleId roleId=new RoleId(roleIdInt);
        RoleName roleName=new RoleName(roleNameStr);
        RoleDescript roleDescript=new RoleDescript(roleDescriptStr);
        Role roleEdit=new Role(roleId,roleName,roleDescript);

        RolePO rolePO=new RolePO(roleEdit.getId().getId(),roleEdit.getName().getName(),roleEdit.getDescript().getDescript());

        rolePO=roleRepository.save(rolePO);//保存将ID返回来

        List<RoleResourcePO> roleResources=new LinkedList<>();
        List<ResourcePO> resources=resourceService.findAllBy(menuIdsIntList);

        for(Integer rid:menuIdsIntList){
            ResourcePO resourcePo=resourceService.findById(resources,rid);
            RoleResourcePO roleResourcePO=new RoleResourcePO(rolePO,resourcePo,0);
            roleResources.add(roleResourcePO);
        }

        roleResourceService.deleteBy(roleId);//清空原角色资源数据

        roleResourceRepository.saveAll(roleResources);
    }


    public void del(Map<String,Object> params){
        Integer roleIdInt=getInt(params.get("id"));
        log.debug("{}",roleIdInt);

        RolePO rolePO=roleRepository.findById(roleIdInt).orElse(null);
        rolePO.setIsDel(1);//删除标记
        roleRepository.save(rolePO);//存储回去
        roleResourceService.updateIsDelByRoleId(roleIdInt);//角色资源
        userRoleService.updateIsDelByRoleId(roleIdInt);//用户角色
    }



}
