package com.exercise.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.exercise.storage.*")
public class StorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageApplication.class, args);
	}

}
