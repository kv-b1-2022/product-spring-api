package com.ecommerceapp.productprice.validation;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ecommerceapp.productprice.model.ProductPrice;


@Component
public class PriceValidation {

	public static void validate(ProductPrice productprice) throws Exception {
		System.out.println(productprice);
		if (productprice.getProductId()<=0) {
			throw new Exception("Invalid Id. Id cannot be empty/blank");
		}
		if (productprice.getProductId()<=0 ) {
			throw new Exception("Invalid ProductId. 	ProductId cannot be empty/blank");
		}
		if (productprice.getPrice() == null || productprice.getPrice() <= 0) {
			throw new Exception("Price Must not be null , Price must be greater than 0");
		}
         if( productprice.getStartDate() == null) {
        	 throw new Exception(" Date cannot be null ");
        	 
         }
      
		if (productprice.getStartDate().isBefore(LocalDate.now())) {
			throw new Exception("Start date cannot be less than current date");
		}
//		if (productprice.getEndDate() == null || productprice.getEndDate().equals("")) {
//			throw new Exception("Invalid StartDate. StartDate cannot be empty/blank1");
//		}
	}

}
