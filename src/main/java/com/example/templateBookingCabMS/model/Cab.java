package com.example.templateBookingCabMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonIgnoreProperties
@Entity
public class Cab {
	
	//Fields
	
	//CAB INFORMATION
	@JsonProperty("cabId")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cabId;
	
	@JsonProperty("fromLocation")
	private String FromLocation;
	@JsonProperty("toLocation")
	private String ToLocation;
	@JsonProperty("typeOfCab")
	private Integer TypeOfCab;
	
	
	//Calculate Fare DATA
	@JsonProperty("rate")
	private Double rate;
	//private Integer rate;
	
	


	public Cab(Integer cabId, String fromLocation, String toLocation, Integer typeOfCab, Double rate) {
		super();
		this.cabId = cabId;
		FromLocation = fromLocation;
		ToLocation = toLocation;
		TypeOfCab = typeOfCab;
		this.rate = rate;
	}


	public Cab() {
		super();
	}


	public Integer getCabId() {
		return cabId;
	}


	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}


	public String getFromLocation() {
		return FromLocation;
	}


	public void setFromLocation(String fromLocation) {
		FromLocation = fromLocation;
	}


	public String getToLocation() {
		return ToLocation;
	}


	public void setToLocation(String toLocation) {
		ToLocation = toLocation;
	}


	public Integer getTypeOfCab() {
		return TypeOfCab;
	}


	public void setTypeOfCab(Integer typeOfCab) {
		TypeOfCab = typeOfCab;
	}


	public Double getRate() {
		return rate;
	}


	public void setRate(Double rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", FromLocation=" + FromLocation + ", ToLocation=" + ToLocation + ", TypeOfCab="
				+ TypeOfCab + ", rate=" + rate + "]";
	}
	
	
	
	


}