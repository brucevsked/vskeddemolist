本反序列化器实现了把目录里文件按整个文件读取的功能
flume自定义反序列化器deserializer

第一步打成jar包
第二步将jar包放到lib里
第三步配置flume文件
agent.sources.s1.deserializer= com.vsked.event.LineDeserializer$Builder

参考
https://www.cnblogs.com/yuwenhui/p/9367625.html