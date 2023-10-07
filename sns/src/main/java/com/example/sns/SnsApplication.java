package com.example.sns;

import com.example.sns.order.utils.HibernateUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.module.Configuration;

@SpringBootApplication
public class SnsApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(SnsApplication.class, args);
//		Object dataSource = context.getBean("dataSource");

		SpringApplication.run(SnsApplication.class, args);
	}

}
