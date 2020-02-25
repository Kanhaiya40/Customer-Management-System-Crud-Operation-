package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class BlogApplication {


	public static void main(String[] args) {
		System.out.println("Hello");

		SpringApplication.run(BlogApplication.class, args);
	}

}
