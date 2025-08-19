# spring boot3+spring security 6 + mysql + mybatis plus + jwt+登录+动态角色菜单

单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1:8181

http://127.0.0.1:8181/test2

http://127.0.0.1/prod-api/test2

http://127.0.0.1/prod-api/profile/images/tiding.png

admin
123456

系统中有两类角色
超级管理员角色
其他角色

超级管理员角色，拥有最高权限，不需要任何权限验证。
其他角色，需要进行权限验证

权限有以下三种
读，写2种权限

权限分类
API权限，菜单权限，页面，按钮权限，表格，列，行,自定义规则





