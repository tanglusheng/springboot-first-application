package com.forezp.springbootfirstapplication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.forezp.springbootfirstapplication.mapper"})
@EnableTransactionManagement//开启springboot事务支持
@ServletComponentScan(basePackages = {"com.forezp.springbootfirstapplication.servlet","com.forezp.springbootfirstapplication.filter"})
public class SpringbootFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstApplication.class, args);
	}
}
