

# 管理后台接口项目  

注意本项目需要使用jdk8

一个用户只允许拥有一个角色  

第一步在数据库中建需要做的功能表

第二步核对 resources/db.txt 文件中数据库配置与缓存是否正确

第三步修改 com.jat.tools.JFinalGenerator 文件中数据库配置是否正确

第四步 运行 com.jat.tools.JFinalGenerator 将新建的功能表生成到com.jat.model目录

第五步 在 com.jat.admin.api中添加控制器并操作对应数据结构即可

第六步 运行 com.jat.Application类启动

测试地址
http://localhost/

如果接口不需要权限访问将地址添加到 com.jat.interceptor.JwtTokenInterceptor 中即可

jfinal拦截器顺序，全局异常拦截，切面处理

--------------------------------------------------------------------------------

开发功能流程
第一步 复制 jatjfinaladminui\src\components\page 相关页面
第二步 修改路由地址 \jatjfinaladminui\src\router\index.js
第三步 修改数据库 resource 表添加菜单资源
第四步 修改 roleResource表为角色添加菜单选项
第五步 新建业务表
第六步 生成业务操作类 com.jat.tools.JFinalGenerator
第七步 编写控制层类 jatjfinaladmin\src\main\java\com\jat\admin\api
第八步 测试相关编写的控制层类

如果有需要在不同控制层复用的方法，可以单独写一个service来调用

--------------------------------------------------------------------------------
post 请求示例  
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


get请求示例
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