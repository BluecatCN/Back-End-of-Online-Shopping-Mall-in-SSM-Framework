package com.succulent.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.succulent")
//@ComponentScan(basePackages = {"com.succulent.controller"})
@MapperScan(value = "com.succulent.**.**.repository")  //每个mapper都加注解比较麻烦，所以统一配置@MapperScan在扫描路径在application类中
public class SucculentUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SucculentUserApplication.class, args);
	}

}
