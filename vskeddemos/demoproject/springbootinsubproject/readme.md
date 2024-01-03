

启动webapp1
访问
http://127.0.0.1:8181/book?bookId=abc&bookName=def999


分层打包时会有一个公用的common层，用来存放公用概念模型
common模块

分层打包时，第一个领域会有一个自己的单元测试，
每个单元测试都会测试一个业务流程，
如usertest项目测试用户相关流程
如ordertest项目测试订单相关流程

第一个模块都会有一个单独的持久化层userpersistance,orderpersistance,paypersistance

如果哪个子项目需要把spring boot打成可执行jar包参考webapp1项目，添加一个 build标签
	<build>
		<!--如果项目需要进spring boot 地方加上这个 -->
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<mainClass>com.jat.Persistance1userApplication</mainClass>
				</configuration>
				<executions>
					<execution>
						<goals><goal>repackage</goal></goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>