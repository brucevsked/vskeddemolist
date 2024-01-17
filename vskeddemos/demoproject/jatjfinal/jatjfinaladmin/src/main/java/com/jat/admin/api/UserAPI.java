package com.jat.admin.api;

import com.alibaba.fastjson.JSONArray;
import com.jat.admin.api.model.TableView;
import com.jat.model.Account;
import com.jat.model.User;
import com.jat.model.UserAccount;
import com.jat.model.UserRole;
import com.jat.util.HttpRequest;
import com.jat.util.JwtKit;
import com.jat.util.CryptoTool;
import com.jat.util.Response;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.ext.interceptor.POST;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/manager/user")
public class UserAPI extends Controller {

    private static final Logger log = LoggerFactory.getLogger(UserAPI.class);

    @Before({POST.class, Tx.class})
    public void login() {
        log.trace("login");

        Response response = new Response();

        Map<String,String> userData=JSON.parseObject(getRawData() , Map.class);

        String userName = HttpRequest.getParam(userData.get("userName"));
        String password = HttpRequest.getParam(userData.get("password"));

        if(userName!=null && password!=null){
            password= CryptoTool.md5Encode(password);
            String token = JwtKit.getToken(userName,password);
            if(token==null) {
                response.setCode(3);
                response.setMsg("用户名或密码不正确！");
                renderJson(response);
                return;
            }
            Map<String,String> data=new HashMap<>();
            data.put("token",token);
            response.setCode(0);
            response.setMsg("登录成功！");
            response.setData(data);
            renderJson(response);
        }else{
            response.setCode(2);
            response.setMsg("用户名或密码为空！");
            renderJson(response);
        }

    }

    public void findById(){
        log.trace("findById");
        Response response = new Response();

        int userId=getParaToInt("id");
        User user=User.dao.findById(userId);
        response.setCode(0);
        response.setMsg("获取用户信息成功！");
        response.setData(user);
        log.info("{}",response);
        renderJson(response);
    }

    public void info(){
        log.trace("info");
        Response response = new Response();

        String userId=JwtKit.getJwtUserIdBy(getRequest());
        User user=User.dao.findById(userId);
        response.setCode(0);
        response.setMsg("获取用户信息成功！");
        response.setData(user);
        log.info("{}",response);
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void logout(){
        log.trace("logout");
        Response response = new Response();
        String token = JwtKit.getToken(getRequest());
        JwtKit.removeToken(token);

        response.setCode(0);
        response.setMsg("注销成功！");
        renderJson(response);
    }

    public void list(){
        log.trace("user list");
        Response response = new Response();

        int pageIndex=getParaToInt("pageIndex"); //当前第几页
        int pageSize=getParaToInt("pageSize"); //每页显示多少条

        String name=HttpRequest.getParam(getPara("name"));
        String accountName=HttpRequest.getParam(getPara("accountName"));
        String phone=HttpRequest.getParam(getPara("phone"));

        Page pageData=User.dao.paginate(pageIndex,pageSize,"select a.id,a.name,a.phone,GROUP_CONCAT(c.name) rolename,e.name accountname ","from `user` a left join userRole b on a.id=b.userId left join role c on b.roleId=c.id left join userAccount d on a.id=d.userId left join account e on d.accountId=e.id where a.isDel=0 and b.isDel=0 and c.isDel=0 and d.isDel=0 and e.isDel=0 and (a.`name` like ? "+(name.length()>0?"":" or a.`name` is null ")+") and (e.`name` like ? "+(accountName.length()>0?"":" or e.`name` is null ")+") and (a.phone like ? "+(phone.length()>0?"":" or a.phone is null ")+")  group by a.id order by a.id desc","%"+name+"%","%"+accountName+"%","%"+phone+"%");

        TableView tableView=new TableView(pageData.getTotalRow(),pageData.getList());

        response.setCode(0);
        response.setMsg("用户列表获取成功！");
        response.setData(tableView);
        renderJson(response);
    }

    public void findUserRole(){
        log.trace("findUserRole");
        Response response = new Response();

        String id= HttpRequest.getParam(getPara("id"));
        log.info("{}",id);
        List userRoles=Db.find("select a.roleId id from userRole a where a.isDel=0 and userId=?",id);

        response.setCode(0);
        response.setMsg("用户角色获取成功！");
        response.setData(userRoles);
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void del(){
        log.trace("del user");
        Response response = new Response();

        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);
        int id=Integer.valueOf(HttpRequest.getParam(reqData.get("id")));
        log.info("{}",id);
        UserAccount userAccount=UserAccount.dao.findFirst("select * from userAccount where userId=?",id);

        Db.update("update user set isDel=1 where id=?",id);//用户
        Db.update("update account set isDel=1 where id=?",userAccount.getAccountId());//账号
        Db.update("update userAccount set isDel=1 where userId=?",id);//用户账号
        Db.update("update userRole set isDel=1 where userId=?",id);//用户角色

        response.setCode(0);
        response.setMsg("删除用户成功！");
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void add(){
        log.trace("add user");
        Response response = new Response();

        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);
        String accountName=HttpRequest.getParam(reqData.get("accountName"));
        String accountPass=HttpRequest.getParam(reqData.get("accountPass"));
        String name=HttpRequest.getParam(reqData.get("name"));
        String phone=HttpRequest.getParam(reqData.get("phone"));

        Account accountOld=Account.dao.findFirst("select a.* from account a where a.name=?",accountName);
        if(accountOld!=null){
            response.setCode(1);
            response.setMsg("添加用户失败账号["+accountName+"]已存在！");
            renderJson(response);
            return;
        }

        if(accountName.length()<2){
            response.setCode(2);
            response.setMsg("添加用户失败账号未输入！");
            renderJson(response);
            return;
        }

        if(accountPass.length()<2){
            response.setCode(2);
            response.setMsg("添加用户失败密码未输入！");
            renderJson(response);
            return;
        }

        accountPass= CryptoTool.md5Encode(accountPass);

        Account account=new Account();
        account.setId(null);
        account.setName(accountName);
        account.setPass(accountPass);
        account.setIsDel(0);//未删除
        account.save();//保存账号

        User user=new User();
        user.setId(null);
        user.setName(name);
        user.setPhone(phone);
        user.setState(0);
        user.setIsDel(0);
        user.save(); //保存用户

        UserAccount userAccount=new UserAccount();
        userAccount.setUserId(user.getId());
        userAccount.setAccountId(account.getId());
        userAccount.setIsDel(0);
        userAccount.save();//保存用户账号

        List<UserRole> userRoles=new LinkedList<>();
        JSONArray rids= (JSONArray) reqData.get("roleIds");
        UserRole userRole=null;
        for(Object rid:rids){
            userRole=new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(Integer.valueOf(rid+""));
            userRole.setIsDel(0);
            userRoles.add(userRole);
        }

        if(userRoles.size()>0){
            int[] saveResultRow=Db.batchSave(userRoles,userRoles.size()); //保存用户角色
            log.info("{}",saveResultRow);
        }

        response.setCode(0);
        response.setMsg("添加用户成功！");
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void edit(){
        log.trace("edit user");
        Response response = new Response();

        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);
        String id=HttpRequest.getParam(reqData.get("id"));
        String name=HttpRequest.getParam(reqData.get("name"));
        String phone=HttpRequest.getParam(reqData.get("phone"));

        log.info("{},{},{}",id,name,phone);
        User user=User.dao.findById(id);//根据唯一标识找
        user.setPhone(phone); //设置属性
        user.setName(name);
        user.update(); //更新

        List<UserRole> userRoles=new LinkedList<>();
        JSONArray rids= (JSONArray) reqData.get("roleIds");
        UserRole userRole=null;
        for(Object rid:rids){
            userRole=new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(Integer.valueOf(rid+""));
            userRole.setIsDel(0);
            userRoles.add(userRole);
        }

        Db.update("delete from userRole where userId=?",id);//清空用户角色

        if(userRoles.size()>0){
            int[] saveResultRow=Db.batchSave(userRoles,userRoles.size()); //保存用户角色
            log.info("{}",saveResultRow);
        }

        response.setCode(0);
        response.setMsg("修改用户成功！");
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void changepwd(){
        log.trace("change account pwd");
        Response response = new Response();

        String userId=JwtKit.getJwtUserIdBy(getRequest());

        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);
        String oldVal=HttpRequest.getParam(reqData.get("oldVal"));
        String newVal=HttpRequest.getParam(reqData.get("newVal"));

        log.info("{},{},{}",userId,oldVal,newVal);

        oldVal=CryptoTool.md5Encode(oldVal);

        Account oldAccount= Account.dao.findFirst("select a.id,a.name,a.pass from account a LEFT JOIN userAccount b on a.id=b.accountId where a.isDel=0 and b.userId=? ",userId);

        log.info("{}",oldAccount);

        if(!oldAccount.getPass().equals(oldVal)){
            response.setCode(1);
            response.setMsg("旧密码输入错误或账号已被禁用！");
            renderJson(response);
            return;
        }

        newVal=CryptoTool.md5Encode(newVal);//加密
        oldAccount.setPass(newVal);//设置新密码
        oldAccount.update();//更新

        response.setCode(0);
        response.setMsg("修改密码成功！");
        renderJson(response);
    }

    @Before({POST.class, Tx.class})
    public void resetUserPwd(){
        log.trace("change account pwd");
        Response response = new Response();

        Map<String,Object> reqData= JSON.parseObject(getRawData() , Map.class);

        log.info("{}",reqData);
        String id=HttpRequest.getParam(reqData.get("id"));
        String accountPass=HttpRequest.getParam(reqData.get("accountPass"));

        if(accountPass.length()<2){
            response.setCode(2);
            response.setMsg("重置密码失败密码未输入！");
            renderJson(response);
            return;
        }

        Account oldAccount= Account.dao.findFirst("select a.id,a.name,a.pass from account a LEFT JOIN userAccount b on a.id=b.accountId where a.isDel=0 and b.userId=? ",id);

        log.info("{}",oldAccount);

        accountPass=CryptoTool.md5Encode(accountPass);

        oldAccount.setPass(accountPass);//设置新密码
        oldAccount.update();//更新

        response.setCode(0);
        response.setMsg("修改密码成功！");
        renderJson(response);
    }

}
