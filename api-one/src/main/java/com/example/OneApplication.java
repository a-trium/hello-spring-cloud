package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class OneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}

	@RestController
	public class OneController {

		@GetMapping("/")
		public String one() {
			return "one one one one one one one one one api server!";
		}

		@GetMapping("/one")
		public String onlyOne() {
			return "this is only one server";
		}
	}

}
