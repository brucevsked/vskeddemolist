
http://localhost:8080/ssmmv0x

http://localhost:8080/ssmmv0x/user/register?username=admin1&password=admin1
http://localhost:8080/ssmmv0x/user/login?username=admin&password=admin
http://localhost:8080/ssmmv0x/user/login?username=admin&password=admin1

1
mvn archetype:generate -DgroupId=com.vsked -DartifactId=ssmmv0 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false -DarchetypeCatalog=internal

2
cd ssmmv0
mvn eclipse:eclipse

right click->configue->cover to maven project

3
fixed the web.xml version

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" version="3.0">

fixed the junit version to 4.12

4
mvn install

本实例抄自
http://www.cnblogs.com/java-zhao/p/5096811.html