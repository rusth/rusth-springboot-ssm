## thymeleaf模板使用说明
使用thymeleaf模板时，比较通用比较简单。  
 
*  pom.xml中配置引用包
	> <dependency>
> 			<groupId>org.springframework.boot</groupId>
> 			<artifactId>spring-boot-starter-thymeleaf</artifactId>
> 		</dependency>

*  application.properties中配置需要使用的参数
    spring.thymeleaf.cache=true  
spring.thymeleaf.content-type=text/html  
spring.thymeleaf.encoding=UTF-8  
spring.thymeleaf.prefix=classpath:/templates/thymeleaf/  
spring.thymeleaf.suffix=.html   
* 完成这些，即可使用thymeleaf模板了。 
