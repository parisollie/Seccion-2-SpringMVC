package com.pjff.curso.srpingboot.webapp.springboot_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * V-33, paso 2.21 le configuramos nuestro archivo value.properties
 * 
 * @PropertySource("classpath:values.properties")
 */
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
