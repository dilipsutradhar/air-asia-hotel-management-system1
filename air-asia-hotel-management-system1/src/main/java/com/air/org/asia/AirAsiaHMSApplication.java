package com.air.org.asia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
///@EnableAutoConfiguration
public class AirAsiaHMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirAsiaHMSApplication.class, args);
	}

}
