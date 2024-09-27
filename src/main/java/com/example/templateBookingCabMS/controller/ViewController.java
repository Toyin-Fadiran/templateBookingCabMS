package com.example.templateBookingCabMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // for Views
public class ViewController {

	// potential fields

	// methods that return VIEWS (not Data)
	// ie methods that serve web content
	@GetMapping("/greeting")
	public String greeting() {
		// Redirecting to the static greeting.html
		return "redirect:/greeting.html";
	}
	
	
	@GetMapping("/book-cab")
	public String bookCab() {
		// Redirecting to the static greeting.html
		return "redirect:/book-cab.html";
	}
	
	
	

}
