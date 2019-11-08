package com.ssiconcatel.test3;

import com.ssiconcatel.test3.controller.RestController;
import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test3Application {


	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(RestController.class);

		SpringApplication.run(Test3Application.class, args);
		logger.info("Starting Application...");
	}

}
