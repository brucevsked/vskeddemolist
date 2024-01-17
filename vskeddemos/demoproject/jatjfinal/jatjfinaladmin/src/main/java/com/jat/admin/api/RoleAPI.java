package com.jat.admin.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jat.admin.api.model.MenuView;
import com.jat.admin.api.model.TableView;
import com.jat.model.IJwtAble;
import com.jat.model.Resource;
import com.jat.model.Role;
import com.jat.model.RoleResource;
import com.jat.model.User;
import com.jat.util.HttpRequest;
import com.jat.util.JwtKit;
import com.jat.util.MenuTool;
import com.jat.util.Response;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Path("/manager/role")
public class RoleAPI extends Controller {

    private static final Logger log = LoggerFactory.getLogger(RoleAPI.class);

    public void findAllRole(){
        log.trace("findAllRole");
        Response response = new Response();

        List<Role> roles=Role.dao.find("select a.* from role a where a.isDel=0");

        response.setCode(0);
        response.setMsg("所有角色获取成功！");
        response.setData(roles);
        renderJson(response);
    }

    public void findById(){
        log.trace("findById");
        Response response = new Response();

        int roleId=getParaToInt("id");
        Role role=Role.dao.findById(roleId);
        response.setCode(0);
        response.setMsg("获取角色信息成功！");
        response.setData(role);
        log.info("{}",response);
        renderJson(response);
    }


    /**
     * 当前用户的角色菜单
     */
    public void roleMenu(){
        log.trace("roleMenu");
        Response response = new Response();
        String token = JwtKit.getToken(getRequest());
        IJwtAble user=JwtKit.getUser(token);
        List<String> resourceIds=user.getForces();
        StringBuffer sb=new StringBuffer();
        for(String resourceId:resourceIds){
            sb.append(resourceId);
            sb.append(",");
        }
        List<Resource> resources=new LinkedList<>();
        if(sb.length()>1){
            sb.setLength(sb.length()-1);
            resources=Resource.dao.find("select a.* from resource a where a.id in("+sb.toString()+") and a.isDel=0 order by a.sequence asc");
        }

        List<MenuView> menus= MenuTool.resourceToMenu(resources);

        response.setCode(0);
        response.setMsg("获取角色菜单成功");
        response.setData(menus);
        renderJson(response);
    }

    public void getRoleResource(){
        log.trace("getRoleResource");
        Response response = new Response();
        String id= HttpRequest.getParam(getPara("id"));
        log.info("{}",id);

        List roleResources=Db.find("select a.resId id from roleResource a where a.isDel=0 and roleId=?",id);

        log.info("{}",roleResources);

        response.setCode(0);
        response.setMsg("获取角色菜单id成功");
        response.setData(roleResources);
        renderJson(response);
    }

    public void list(){
        log.trace("role list");
        Response response = new Response();

        int pageIndex=getParaToInt("pageIndex"); //当前第几页
        int pageSize=getParaToInt("pageSize"); //每页显示多少条
        String name= HttpRequest.getParam(getPara("name"));

        Page pageData= Role.dao.paginate(pageIndex,pageSize,"select a.*","from role a where a.isDel=0 and ( a.`name` like ? "+(name.length()>0?"":" or a.`name` is null ")+") order by a.id desc","%"+name+"%");

        TableView tableView=new TableView(pageData.getTotalRow(),pageData.getList());

        response.setCode(0);
        response.setMsg("角色列表获取成功！");
        response.setData(tableView);
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void del(){
        log.trace("del role");
        Response response = new Response();

        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);
        int id=Integer.valueOf(HttpRequest.getParam(reqData.get("id")));
        log.info("{}",id);

        Db.update("update role set isDel=1 where id=?",id);//角色
        Db.update("update roleResource set isDel=1 where roleId=?",id);//角色资源
        Db.update("update userRole set isDel=1 where roleId=?",id);//用户角色

        response.setCode(0);
        response.setMsg("删除角色成功！");
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void add() {
        log.trace("add resource");
        Response response = new Response();
        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);

        Role roleAdd=new Role();
        roleAdd.setId(null);//id自增长
        roleAdd.setName(HttpRequest.getParam(reqData.get("name")));
        roleAdd.setDescript(HttpRequest.getParam(reqData.get("descript")));
        roleAdd.setIsDel(0);//未删除
        roleAdd.save(); //保存角色

        Integer roleIdNew=roleAdd.getId();//取刚保存的角色编号

        List<RoleResource> roleResources=new LinkedList<>();
        JSONArray rids= (JSONArray) reqData.get("menuIds");
        RoleResource roleResource=null;
        for(Object rid:rids){
            roleResource=new RoleResource();
            roleResource.setRoleId(roleIdNew);
            roleResource.setResId(Integer.valueOf(rid+""));
            roleResource.setIsDel(0);
            roleResources.add(roleResource);
        }
        if(roleResources.size()>0){
            int[] saveResultRow=Db.batchSave(roleResources,roleResources.size()); //保存角色资源对应关系
            log.info("{}",saveResultRow);
        }

        response.setCode(0);
        response.setMsg("添加角色成功！");
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void edit() {
        log.trace("edit resource");
        Response response = new Response();

        Map<String, Object> reqData = JSON.parseObject(getRawData(), Map.class);

        log.info("{}", reqData);

        int id=Integer.valueOf(HttpRequest.getParam(reqData.get("id")));

        Role roleEdit=Role.dao.findById(id);
        roleEdit.setName(HttpRequest.getParam(reqData.get("name")));
        roleEdit.setDescript(HttpRequest.getParam(reqData.get("descript")));
        roleEdit.setIsDel(0);//未删除
        roleEdit.update(); //更新角色

        List<RoleResource> roleResources=new LinkedList<>();
        JSONArray rids= (JSONArray) reqData.get("menuIds");
        RoleResource roleResource=null;
        for(Object rid:rids){
            roleResource=new RoleResource();
            roleResource.setRoleId(id);
            roleResource.setResId(Integer.valueOf(rid+""));
            roleResource.setIsDel(0);
            roleResources.add(roleResource);
        }

        Db.update("delete from roleResource where roleId=?",id);//清空原角色资源数据

        if(roleResources.size()>0){
            int[] saveResultRow=Db.batchSave(roleResources,roleResources.size()); //保存角色资源对应关系
            log.info("{}",saveResultRow);
        }

        response.setCode(0);
        response.setMsg("修改角色成功！");
        renderJson(response);
    }
}
