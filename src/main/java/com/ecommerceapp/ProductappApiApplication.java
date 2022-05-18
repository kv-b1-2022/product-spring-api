package com.ecommerceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProductappApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappApiApplication.class, args);

		System.out.println("Success");
		System.out.println("running...");
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	 return new WebMvcConfigurer() {
	   @Override
	   
	   public void addCorsMappings(CorsRegistry registry) {
	     registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	   }
	 };
	}


}
