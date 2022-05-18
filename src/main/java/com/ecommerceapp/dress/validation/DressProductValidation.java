package com.ecommerceapp.dress.validation;

import com.ecommerceapp.dress.model.DressProduct;

public class DressProductValidation {

	public static void validateDress(DressProduct dress) throws Exception {
		if (dress.getName() != null) {
		} else {
			throw new Exception("The name cannot be empty");
		}
		if (dress.getBrand() != null) {
		} else {
			throw new Exception("The name cannot be empty");
		}
		if (dress.getCategory() != null) {
		} else {
			throw new Exception("The name cannot be empty");
		}
		if (dress.getPrice() != null) {
		} else {
			throw new Exception("The price cannot be empty");
		}
		System.out.println("You have added dress");

	}
}
