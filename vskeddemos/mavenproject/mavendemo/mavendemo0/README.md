
1
mvn archetype:generate -X -DgroupId=com.vsked -DartifactId=mavendemo0 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false -DarchetypeCatalog=internal

2
cd mavendemo0
mvn eclipse:eclipse

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