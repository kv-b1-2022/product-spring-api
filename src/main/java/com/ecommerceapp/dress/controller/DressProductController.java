package com.ecommerceapp.dress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapp.dress.dto.MessageDTO;
import com.ecommerceapp.dress.dao.DressProductRepository;
import com.ecommerceapp.dress.model.DressProduct;
import com.ecommerceapp.dress.service.DressProductService;

@RestController
public class DressProductController {
	@Autowired
	DressProductRepository dressproductRepository;
	
	@Autowired
	DressProductService dressproductService;

	@PostMapping("dress/save") // dress details will be insert
	public ResponseEntity  <String> save(@RequestBody DressProduct dress){
		try {
			dressproductService.save(dress);
			return new ResponseEntity<String> (HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);      
		}
	}

	@GetMapping("dress/list") // list all dresses
	public List<DressProduct> findAll() {
		List<DressProduct> dresslist = null;
		try {
			dresslist=dressproductService.findAll();
			}catch(Exception e) {
				e.getMessage();
			}
		return dresslist;
	}
	
	@DeleteMapping("dress/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		try {
		
			dressproductService.deleteById(id);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message,HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}

	}

	@PutMapping("dress/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody DressProduct product) {
		try {
			dressproductService.update(id, product);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}
	}
	@GetMapping("dress/{id}") // find by user Id
	public DressProduct findById(@PathVariable("id") Integer id) {
		System.out.println("findById " + id);
		DressProduct product= dressproductService.findById(id);
		return product;
	}



	}
	

