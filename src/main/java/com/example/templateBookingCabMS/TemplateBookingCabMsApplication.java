package com.example.templateBookingCabMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TemplateBookingCabMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateBookingCabMsApplication.class, args);
	}

}
