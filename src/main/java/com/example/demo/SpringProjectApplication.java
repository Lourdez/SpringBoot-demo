package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext context = SpringApplication.run(SpringProjectApplication.class, args);
//			mysqlconn s = context.getBean(mysqlconn.class);
			
			
			Home h = context.getBean(Home.class);
			h.connect();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}
	}

}
