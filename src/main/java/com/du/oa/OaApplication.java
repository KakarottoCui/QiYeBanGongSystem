package com.du.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.du.oa.dao")
@SpringBootApplication
public class OaApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(OaApplication.class, args);
		System.out.println("**********************************");
		System.out.println("*      start-up success      *");
		System.out.println("**********************************"); 
	}
}
