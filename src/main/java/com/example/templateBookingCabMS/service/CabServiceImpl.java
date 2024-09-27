package com.example.templateBookingCabMS.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.templateBookingCabMS.dao.CabRepository;
import com.example.templateBookingCabMS.model.Cab;

@Service  //type of @Component
public class CabServiceImpl implements CabService {
	
	
	
	@Autowired
	private CabRepository cabRepository;

	@Override
	public Cab bookCab(Cab cab) {
		// TODO Auto-generated method stub
		return cabRepository.save(cab);
	}

	@Override
	public Optional<Cab> getCabById(Integer id) {
		// TODO Auto-generated method stub
		 return cabRepository.findById(id);
	}

	@Override
	public List<Cab> getAllBookedCabs() {
		// TODO Auto-generated method stub
		return new ArrayList<Cab>((Collection<? extends Cab>) cabRepository.findAll());
	}

	@Override
	public void deleteCab(Integer id) {
		// TODO Auto-generated method stub
		cabRepository.deleteById(id);
		
	}
	
	

}
