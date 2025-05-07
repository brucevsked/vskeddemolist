
Spring boot3+r2dbc+mysql+ spring security+reactive +testNG +maven +动态菜单 技术示例  
只能用于主键自增的表可以保存，还需要进一步研究  


下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1:8181
http://127.0.0.1:8181/t1

SecretKey的值就是,这个值在https://jwt.io/验证的时候Secret来使用
shandongyunzecompanydevelope做完base64以后
c2hhbmRvbmd5dW56ZWNvbXBhbnlkZXZlbG9wZQ==

{    "username":"admin",    "password":"123456" }
curl -X POST http://localhost:8181/auth/login -H "Content-Type:application/json" -d "{\"username\":\"admin\", \"password\":\"123456\"}"
curl -X GET http://localhost:8181/me -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9hZG1pbiIsImlhdCI6MTc0NTkxMzM2OCwiZXhwIjoxNzQ1OTE2OTY4fQ.2hEH-BJPta-Dpcw_xT-qBswaXntjafLDnGzEqJIBIgw"



todo  是否要将jwt值保存到redis中?

