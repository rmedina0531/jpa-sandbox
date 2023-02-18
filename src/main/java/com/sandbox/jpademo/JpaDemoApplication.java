package com.sandbox.jpademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JpaDemoApplication {

	public static void main(String[] args) {
		log.info("Hello world");
		SpringApplication.run(JpaDemoApplication.class, args);
	}

}
