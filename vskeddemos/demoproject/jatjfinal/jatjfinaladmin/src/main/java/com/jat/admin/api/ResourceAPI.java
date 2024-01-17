package com.jat.admin.api;

import com.alibaba.fastjson.JSON;
import com.jat.admin.api.model.MenuView;
import com.jat.admin.api.model.TableView;
import com.jat.model.Resource;
import com.jat.util.HttpRequest;
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
import java.util.List;
import java.util.Map;

@Path("/manager/resource")
public class ResourceAPI extends Controller {

    private static final Logger log = LoggerFactory.getLogger(ResourceAPI.class);

    /**
     * 所有菜单
     */
    public void allMenus(){
        log.trace("allMenus");
        Response response = new Response();

        List<Resource> resources=Resource.dao.find("select a.* from resource a where a.isDel=0 order by a.sequence asc");

        List<MenuView> menus= MenuTool.resourceToMenu(resources);

        response.setCode(0);
        response.setMsg("获取所有菜单成功");
        response.setData(menus);
        renderJson(response);
    }

    public void findAll(){
        log.trace("findAll");
        Response response = new Response();

        List<Resource> resourceList=Resource.dao.find("select a.id,a.`name` from resource a where a.isDel=0");

        response.setCode(0);
        response.setMsg("资源列表获取成功！");
        response.setData(resourceList);
        renderJson(response);
    }

    public void findById(){
        log.trace("findById");
        Response response = new Response();

        String id= HttpRequest.getParam(getPara("id"));
        if("".equals(id)){
            response.setCode(1);
            response.setMsg("资源获取失败,未传入编号！");
            renderJson(response);
            return;
        }

        Resource resource=Resource.dao.findById(id);

        response.setCode(0);
        response.setMsg("资源获取成功！");
        response.setData(resource);
        renderJson(response);
    }

    public void list(){
        log.trace("resource list");
        Response response = new Response();

        int pageIndex=getParaToInt("pageIndex"); //当前第几页
        int pageSize=getParaToInt("pageSize"); //每页显示多少条
        String name= HttpRequest.getParam(getPara("name"));
        String url= HttpRequest.getParam(getPara("url"));
        String parentName= HttpRequest.getParam(getPara("parentName"));

        Page pageData= Resource.dao.paginate(pageIndex,pageSize,"select a.*,b.`name` parentName","from resource a left join resource b on a.parentId=b.id  where a.isDel=0 and (a.`name` like ? "+(name.length()>0?"":" or a.`name` is null ")+") and (a.url like ? "+(url.length()>0?"":" or a.url is null ")+" ) and (b.`name` like ? "+(parentName.length()>0?"":" or b.`name` is null ")+") order by a.id desc","%"+name+"%","%"+url+"%","%"+parentName+"%");

        TableView tableView=new TableView(pageData.getTotalRow(),pageData.getList());

        response.setCode(0);
        response.setMsg("资源列表获取成功！");
        response.setData(tableView);
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void del(){
        log.trace("del resource");
        Response response = new Response();

        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);
        int id=Integer.valueOf(HttpRequest.getParam(reqData.get("id")));
        log.info("{}",id);

        Db.update("update resource set isDel=1 where id=?",id);//资源
        Db.update("update roleResource set isDel=1 where resId=?",id);//角色资源

        response.setCode(0);
        response.setMsg("删除资源成功！");
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void add(){
        log.trace("add resource");
        Response response = new Response();

        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);

        Integer parentId=Integer.parseInt(reqData.get("parentId")+"");
        if(parentId==-1){
            parentId=null;
        }

        Integer sequence=Integer.parseInt(reqData.get("sequence")+"");

        Resource resourceAdd=new Resource();
        resourceAdd.setId(null);//id自增长
        resourceAdd.setName(HttpRequest.getParam(reqData.get("name")));
        resourceAdd.setUrl(HttpRequest.getParam(reqData.get("url")));
        resourceAdd.setIcon(HttpRequest.getParam(reqData.get("icon")));
        resourceAdd.setType(HttpRequest.getParam(reqData.get("type")));
        resourceAdd.setSequence(sequence);
        resourceAdd.setParentId(parentId);
        resourceAdd.setIsDel(0);//未删除
        resourceAdd.save();

        response.setCode(0);
        response.setMsg("添加资源成功！");
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void edit(){
        log.trace("edit resource");
        Response response = new Response();

        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);

        Integer parentId=Integer.parseInt(reqData.get("parentId")+"");
        if(parentId==-1){
            parentId=null;
        }

        Integer sequence=Integer.parseInt(reqData.get("sequence")+"");

        Resource resourceAdd=new Resource();
        resourceAdd.setId(Integer.parseInt(reqData.get("id")+""));//id自增长
        resourceAdd.setName(HttpRequest.getParam(reqData.get("name")));
        resourceAdd.setUrl(HttpRequest.getParam(reqData.get("url")));
        resourceAdd.setIcon(HttpRequest.getParam(reqData.get("icon")));
        resourceAdd.setType(HttpRequest.getParam(reqData.get("type")));
        resourceAdd.setSequence(sequence);
        resourceAdd.setParentId(parentId);
        resourceAdd.setIsDel(0);//未删除
        resourceAdd.update();

        response.setCode(0);
        response.setMsg("修改资源成功！");
        renderJson(response);
    }
}
