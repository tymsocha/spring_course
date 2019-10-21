package com.myprojects.kursspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:config/spring-config.xml")
public class KursSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(KursSpringApplication.class, args);
	}

}
