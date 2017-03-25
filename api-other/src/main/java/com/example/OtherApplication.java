package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class OtherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtherApplication.class, args);
	}

	@RestController
	public class OtherController {

		@GetMapping("/")
		public String other() {
			return "Other !!!!!!!!!!!!!!!!!!!";
		}

	}
}
