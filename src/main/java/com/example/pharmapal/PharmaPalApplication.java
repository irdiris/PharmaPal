package com.example.pharmapal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class PharmaPalApplication {



	public static void main(String[] args) {
		SpringApplication.run(PharmaPalApplication.class, args);
	}

}

