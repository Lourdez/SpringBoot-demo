package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main (String[] args) {
		try {
			ConfigurableApplicationContext context = SpringApplication.run(SpringProjectApplication.class, args);
			
			MysqlConnection MySql = context.getBean(MysqlConnection.class);
			MySql.connect();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}
	}

}
