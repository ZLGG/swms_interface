package com.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@ServletComponentScan(value = "com.mk")
@MapperScan(basePackages = "com.mk")
@EnableScheduling
@EnableTransactionManagement
public class MallinterfaceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MallinterfaceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MallinterfaceApplication.class, args);
	}


}