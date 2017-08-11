package com.framework.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.framework.common.**.dao")
public class GeneratorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GeneratorApplication.class, args);
	}
}
