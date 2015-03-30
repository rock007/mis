package com.sam.abcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@ComponentScan
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AbcdApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcdApplication.class, args);
	}
}