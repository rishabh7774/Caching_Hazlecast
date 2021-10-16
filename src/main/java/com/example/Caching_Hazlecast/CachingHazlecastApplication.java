package com.example.Caching_Hazlecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachingHazlecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingHazlecastApplication.class, args);
	}

}
