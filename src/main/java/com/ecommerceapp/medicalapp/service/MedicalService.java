package com.ecommerceapp.medicalapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceapp.medicalapp.model.Medical;
import com.ecommerceapp.medicalapp.repository.MedicalRepository;
import com.ecommerceapp.medicalapp.validation.MedicalValidation;





@Service
public class MedicalService {
	@Autowired
	MedicalRepository medicalRepository;
	
	@Autowired
	MedicalValidation medicalValidation;

	public void save(Medical product) throws Exception {
		try {
			medicalValidation.medicalValidation(product);
			medicalRepository.save(product);
		} catch (Exception e) {
			// e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public Optional<Medical> findById(Integer id) {
		Optional<Medical> product = medicalRepository.findById(id);
		
		return product;
	}

	public void deleteById(Integer id) throws Exception {
		try {
			medicalRepository.deleteById(id);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public List<Medical> findAll() throws Exception {
		List<Medical> listproduct;
		try {
			listproduct=medicalRepository.findAll();
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		return listproduct;
	} 
}
