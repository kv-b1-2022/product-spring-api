package com.ecommerceapp.dress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerceapp.dress.dao.DressProductRepository;
import com.ecommerceapp.dress.model.DressProduct;
import com.ecommerceapp.dress.validation.DressProductValidation;

@Service
public class DressProductService {

	@Autowired
	DressProductRepository dressproductRepository;
	
	public void save( DressProduct dress) throws Exception {
		try { 
			DressProductValidation.validateDress(dress);
			dressproductRepository.save(dress);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<DressProduct> findAll() throws Exception {
		List<DressProduct> listdress=null;
		try {
			listdress=dressproductRepository.findAll();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return listdress;
	}

	public void update(@PathVariable("id") Integer id, @RequestBody DressProduct dress)throws Exception{
		try {
			dress.setId(id);
			DressProductValidation.validateDress(dress);
			dressproductRepository.save(dress);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void deleteById(Integer id) throws Exception {
		try {
			dressproductRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public DressProduct findById(Integer id) {
		Optional<DressProduct> dress = dressproductRepository.findById(id);
		if (dress.isPresent()) {
			DressProduct productObj = dress.get();
			return productObj;
		} else {
			return null;
		}
	}
	
}