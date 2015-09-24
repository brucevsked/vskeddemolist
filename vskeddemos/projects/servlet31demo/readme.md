CRUD        HTTP
Create      POST
Read        GET
Update      PUT
Delete      DELETE



--------------------------------------------------------------------------------
修改tomcat目录下conf中web.xml在org.apache.catalina.servlets.DefaultServlet添加初始化参数就可以支持put与delete
        <init-param>  
            <param-name>readonly</param-name>  
            <param-value>false</param-value> 
        </init-param>
        
我试了下不管用调试中