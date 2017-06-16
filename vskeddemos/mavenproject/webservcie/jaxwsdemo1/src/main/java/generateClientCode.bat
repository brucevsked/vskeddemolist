rem 生成客户端调用类
wsimport -keep -d .\ -p com.vsked.client http://localhost:8080/jaxwsdemo1/service/sayHi?wsdl
pause