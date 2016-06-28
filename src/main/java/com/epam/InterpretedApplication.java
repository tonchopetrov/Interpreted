package com.epam;

import com.epam.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class InterpretedApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterpretedApplication.class, args);
	}
}
