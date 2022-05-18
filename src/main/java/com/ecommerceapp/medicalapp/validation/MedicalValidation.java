package com.ecommerceapp.medicalapp.validation;

import org.springframework.stereotype.Component;

import com.ecommerceapp.medicalapp.model.Medical;
import com.ecommerceapp.medicalapp.model.User;








@Component

// Product Validation 
public class MedicalValidation {
	public void medicalValidation(Medical product ) throws Exception{
		if(product.getProductName()==null || (product.getProductName()).trim()=="") {
			throw new Exception("No Product is avalable");
			
	}
		if(product.getBrandName()==null) {
			throw new Exception("select Brand name");
		}
		if(product.getPrice()== null || product.getPrice()<=0) {
			throw new Exception("Price Must not be null");
		}
}
	//login validation
	public void loginValidation(User user) throws Exception{
		if(user.getEmail()==null ||!(user.getEmail()).contains("@gmail.com")){
			throw new Exception("Invalide mail");
		}
		if (user.getPass().length()<=8) {
			throw new Exception("password must be greater then 8 charater");
		}
		
	}
	}

