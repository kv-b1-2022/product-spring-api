package com.ecommerceapp.productprice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapp.productprice.dto.MessageDTO;
import com.ecommerceapp.productprice.model.ProductPrice;
import com.ecommerceapp.productprice.service.ProductPriceService;

@RestController
public class ProductPriceController {
	@Autowired
	ProductPriceService productpriceService;

	@PostMapping("productprice/save")
	public ResponseEntity<?> addStock(@RequestBody ProductPrice productprice) {
		try {

			productpriceService.save(productprice);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("productprice/list")
	public ResponseEntity findAllProducts() {
		List<ProductPrice> listProductPrice = null;
		try {

			listProductPrice = productpriceService.findProducts();
			return new ResponseEntity<>(listProductPrice,HttpStatus.OK);

		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		return listProductPrice;
	}

}