package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class EdgeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeServerApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@RestController
	public class ZuulController {

		@Autowired
		private RestTemplate restTemplate;

		@GetMapping("/zuul")
		public String zuul() {
			return "this is zuul";
		}

		@GetMapping("/api1")
		public String api() {
			return this.restTemplate.getForObject("http://eureka-client", String.class);
		}

		@GetMapping("/api2")
		public String other() {
			return this.restTemplate.getForObject("http://eureka-other-client", String.class);
		}
	}


	@Bean
	public ZuulLoggingFilter zuulLoggingFilter() {
		return new ZuulLoggingFilter();
	}
}
