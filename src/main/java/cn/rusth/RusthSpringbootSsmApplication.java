package cn.rusth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 运行主方法，使用此方法启动项目，自动加载tomcat
 */
@SpringBootApplication
public class RusthSpringbootSsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RusthSpringbootSsmApplication.class, args);
	}
}
