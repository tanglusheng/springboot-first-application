package com.forezp.springboot;

import com.forezp.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootJavaApplication implements CommandLineRunner{//实现方式2
	@Autowired
	private UserService userService;

	//实现方式2
	public static void main(String[] args) {
		//启动springboot容器
//		SpringApplication.run(SpringbootJavaApplication.class, args);
		//关闭banner
		SpringApplication springApplication=new SpringApplication(SpringbootJavaApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

	/**
	 * 相当于纯java的main方法
	 * @param strings
	 * @throws Exception
	 */
	@Override//实现方式2
	public void run(String... strings) throws Exception {
		System.out.println(userService.sayHi("tangls"));
	}

	/*public static void main(String[] args) {//实现方式1
		ConfigurableApplicationContext context=SpringApplication.run(SpringbootJavaApplication.class, args);
		UserService userService = context.getBean("userServiceImpl", UserService.class);
		System.out.println(userService.sayHi("tangls"));
	}*/

}
