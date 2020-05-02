
创建软链接（管理员模式cmd）
mklink /j "D:\env\apache-tomcat-9.0.12\webapps\myui" "D:\project\vskeddemolist\vskeddemolist\todo\springsecurity\src\main\webapp"


不需要权限配置访问测试
http://127.0.0.1:8181/test
需要权限过滤访问测试
http://127.0.0.1:8181/hello
默认登录处理后台地址，也就是登录界面提交地址
http://127.0.0.1:8181/authentication/form

前后端分离的前端登录地址在tomcat里，要先启tomcat
http://127.0.0.1:8080/myui/auth/login.html

maven
数据库密码加密
SpringMVC
SpringSecurity
SpringDataJpa
Redis

Log4j2
TestNG


部门
角色
资源
权限
角色权限
用户

用户角色
角色权限
权限资源
用户部门


需要权限配置的

1在下面类中添加需要登录后访问的url
RbacAuthorityService
2前台登录后会取到token
3访问刚才需要登录后的url里带上token参数

不需要权限过滤的地址
只需要在SpringSecurityConfig配置文件的新添加一条即可
    public void configure(WebSecurity web) throws Exception {
        //对这个地址不进行拦截
        web.ignoring().antMatchers("/test");
        web.ignoring().antMatchers("/login");
        web.ignoring().antMatchers("/loginproc");
        //可以仿照上面一句忽略静态资源
    }
