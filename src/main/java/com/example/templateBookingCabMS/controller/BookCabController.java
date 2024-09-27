package com.example.templateBookingCabMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.templateBookingCabMS.config.FeignService;
import com.example.templateBookingCabMS.model.Cab;
import com.example.templateBookingCabMS.service.CabService;

@RestController
@Configuration
@RequestMapping(path = "cab")
@CrossOrigin(origins="http://localhost:4200")
public class BookCabController {

	// Fields (Autowired fields)
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CabService cabService;
	
	@Value("${app.greeting}")
	private String testGreeting;
	
	@Autowired
	private FeignService feignService;

	// Methods (Handler methods
	// --methods that return a response to the caller
	@GetMapping("/all")
	public ResponseEntity<List<Cab>> getAllCabs() {
		
		System.out.println("retrieving all Booked Cabs");
		
		List<Cab> allCabsList = cabService.getAllBookedCabs();
							//200
		return ResponseEntity.ok(allCabsList);
//		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
	
	@PostMapping("/add")
	public String addBookedCab(@RequestParam String FromLocation, @RequestParam String ToLocation,
			@RequestParam Integer TypeOfCab) {
		// created cab to Book
		Cab cab = new Cab(1, FromLocation, ToLocation, TypeOfCab, 50.0);

		return null;
	}

	// highly Recommended
	@PostMapping("/addtwo") // spring created
	public ResponseEntity<Cab> addBookedCabtwo(@RequestBody Cab cab) {
//		public String addBookedCabtwo(@RequestBody Cab cab) {

		// Reach out to the Calculate Fare MicroService, to calculate the Fare
		// internally.
	//	String url = "http://localhost:8084/calculateFare";
//		String url = "http://TEMPLATECALCULATEFARE/calculateFare";

		// Build the URL with query parameters
	//	String uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("fromLocation", cab.getFromLocation())
		//		.queryParam("toLocation", cab.getToLocation()).toUriString();

		// Create an HttpEntity to hold any request headers (if needed)
//		HttpEntity<Void> entity = new HttpEntity<>(null);
		//HttpEntity<Double> entity = new HttpEntity<>(null);

		// Exchange method to perform the GET request
		//ResponseEntity<Double> response = restTemplate.exchange(uri, HttpMethod.GET, entity, Double.class);

		ResponseEntity<Double> calcFareResponse  =  feignService.calculateFare(cab.getFromLocation(), cab.getToLocation());
		
		
		Double calculatedFare = calcFareResponse.getBody(); //20.0

		// Add that fare we get back, to our CAB OBJECT that we received.
		cab.setRate(calculatedFare);

		
		//Sending the Cab Object to the DB, then returning the successful send to the client WITH
		//extra information detailing the Fare PRICE.
		  Cab cabBookedToDB = cabService.bookCab(cab);
		
		
		
		//send JSON back to FRONT END, which can do whatever you want with it.
		System.out.println("testing!: " + testGreeting);
		
		//return cab.toString();
		  return ResponseEntity.status(HttpStatus.CREATED)
        		.body(cabBookedToDB);
	}

}
