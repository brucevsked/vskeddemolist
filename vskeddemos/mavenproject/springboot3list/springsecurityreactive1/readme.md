
Spring boot3+r2dbc+mysql+ spring security+reactive +testNG +maven 技术示例  
只能用于主键自增的表可以保存，还需要进一步研究  


下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1:8181
http://127.0.0.1:8181/t1




curl -X POST http://localhost:8181/auth/login -H "Content-Type:application/json" -d "{\"username\":\"admin\", \"password\":\"123456\"}"

