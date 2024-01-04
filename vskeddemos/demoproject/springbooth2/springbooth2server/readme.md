
## spring boot+H2 服务器模式


## 创建数据库
java -cp h2-2.1.214.jar org.h2.tools.Shell

D:\h2test>java -cp h2-2.1.214.jar org.h2.tools.Shell

Welcome to H2 Shell 2.1.214 (2022-06-13)
Exit with Ctrl+C
[Enter]   jdbc:h2:~/test  #在下面输入创建数据库要存储的地址
URL       jdbc:h2:d:/h2test/test202210141505
[Enter]   org.h2.Driver
Driver
[Enter]
User      root
Password
Type the same password again to confirm database creation.
Password
Connected
Commands are case insensitive; SQL statements end with ';'
help or ?      Display this help
list           Toggle result list / stack trace mode
maxwidth       Set maximum column width (default is 100)
autocommit     Enable or disable autocommit
history        Show the last 20 statements
quit or exit   Close the connection and exit

sql> quit

H2数据库服务器模式启动命令  
java -cp h2-2.1.214.jar org.h2.tools.Server -tcpAllowOthers -baseDir d:/h2test/ -webPort 8082 -tcpPort 9092

注：org.h2.tools.Server　　以服务器模式启动
-tcpAllowOthers 　　　 允许远程主机通过TCP方式访问
-webAllowOthers 　　   允许远程机器通过浏览器访问
-webPort 8082　　　　 默认的访问端口（8082为未被占用的端口，如果此端口已经被其他端口占用，则改为其他端口）
-tcpPort 9092　　　　　启动TCP服务
-baseDir　~/db　　　　设置数据库根目录 这里我设置到d:/h2test/目录下




----------
Usage: java org.h2.tools.Server <options>
When running without options, -tcp, -web, -browser and -pg are started.

Options are case sensitive.
Supported options[-help] or [-?]Print the list of options
[-web]                  Start the web server with the H2 Console
[-webAllowOthers]       Allow other computers to connect - see below
[-webDaemon]            Use a daemon thread
[-webPort <port>]       The port (default: 8082)
[-webSSL]               Use encrypted (HTTPS) connections
[-webAdminPassword]     Password of DB Console administrator
[-browser]              Start a browser connecting to the web server
[-tcp]                  Start the TCP server
[-tcpAllowOthers]       Allow other computers to connect - see below
[-tcpDaemon]            Use a daemon thread
[-tcpPort <port>]       The port (default: 9092)
[-tcpSSL]               Use encrypted (SSL) connections
[-tcpPassword <pwd>]    The password for shutting down a TCP server
[-tcpShutdown "<url>"]  Stop the TCP server; example: tcp://localhost
[-tcpShutdownForce]     Do not wait until all connections are closed
[-pg]                   Start the PG server
[-pgAllowOthers]        Allow other computers to connect - see below
[-pgDaemon]             Use a daemon thread
[-pgPort <port>]        The port (default: 5435)
[-properties "<dir>"]   Server properties (default: ~, disable: null)
[-baseDir <dir>]        The base directory for H2 databases (all servers)
[-ifExists]             Only existing databases may be opened (all servers)
[-ifNotExists]          Databases are created when accessed
[-trace]                Print additional trace information (all servers)
[-key <from> <to>]      Allows to map a database name to another (all servers)
The options -xAllowOthers are potentially risky.

这时候会打开浏览器，选择你要运行的数据库模式，如服务器模式
JDBC URL填入
jdbc:h2:tcp://10.0.192.1/d:/h2test/test202210141505
输入上面创建的用户名root密码root
然后就可以连接上了


面向业务编程  

单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  


