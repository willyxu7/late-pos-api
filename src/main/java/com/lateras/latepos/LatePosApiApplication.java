package com.lateras.latepos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class LatePosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatePosApiApplication.class, args);
	}

}
