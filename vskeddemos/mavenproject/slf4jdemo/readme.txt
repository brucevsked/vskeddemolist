
添加MDC中mdc_trace_id


如果需要修改请修改
1
xml配置中
traceId:[%X{mdc_trace_id}]
要改两个一个是控制台一个是文件

2
TraceUtils类中修改日志编号

3使用
Slf4jLogTest类中
MDCTest1方法