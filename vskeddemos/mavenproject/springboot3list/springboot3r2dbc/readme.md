
maven+Spring boot3+r2dbc+mysql技术示例   
使用usersRepository时，如果表ID为自增字段，有ID时会做更新操作，无ID时会做插入操作。  
使用R2dbcEntityTemplate entityTemplate时，不管表是否自增，都可以插入或更新。  


下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1:8181
http://127.0.0.1:8181/testCreate

http://127.0.0.1:8181/test2



