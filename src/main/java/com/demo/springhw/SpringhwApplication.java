package com.demo.springhw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SpringhwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringhwApplication.class, args);
	}

}
