动态代理相关技术<br>

使用场景：<br>
1日志记录，<br>
2权限校验，<br>
3方法运行时长监控,监控性能<br>
4缓存优化 （第一次调用查询数据库，将查询结果放入内存对象， 第二次调用， 直接从内存对象返回，不需要查询数据库 ）<br>
5事务管理 （调用方法前开启事务， 调用方法后提交关闭事务 ）<br>
6Resource pooling　资源池<br>
7rror handling 错误处理<br>
8Lazy loading 懒加载<br>

bytebuddyproxy 推荐<br>
cglibdynamicproxy<br>
javassistdynamicproxy<br>
jdkdynamicproxy<br>
springaop<br>
springbootaop<br>
ASM,需要用到字节码,jvm汇编暂不考虑<br>
