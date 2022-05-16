package com.ecommerceapp.medicalapp.ordercontroller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.ecommerceapp.medicalapp.model.Medical;
import com.ecommerceapp.medicalapp.service.MedicalService;
import com.ecommerceapp.productprice.dto.MessageDTO;








@RestController
public class MedicalController {
	
	
	@Autowired
	MedicalService medicalService;


	@PostMapping("Product/save")//insert product
	public ResponseEntity<?> save(@RequestBody Medical product) {
		
	
		try {
			
			medicalService.save(product);
			MessageDTO message=new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
		catch(Exception e){
			MessageDTO message=new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("Product/list")//product
	public List<Medical> findAllMedicines() {
		List<Medical> list = null;
		try {
			list=medicalService.findAll();
		}catch(Exception e) {
			
			e. printStackTrace();
		}
		return list;
	}

	@PutMapping("Product/update/{id}") // update products
	public void update(@PathVariable("id") Integer id, @RequestBody Medical product) {
		product.setId(id);
		try {
			medicalService.save(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DeleteMapping("Product/delete/{id}")//delete products
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		try {
			medicalService.deleteById(id);
			MessageDTO message=new MessageDTO("Success");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message=new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("Product/{id}")//find user by id
	public Medical findById(@PathVariable("id") Integer id) {
		System.out.println("findById"+ id);
		Optional<Medical> list = medicalService.findById(id);
		if(list.isPresent()) {
		 Medical obj = list.get();
		 return obj;
		}
		else {
			return null;
		}
   }
	@GetMapping("ListProducts/name")//find by name
	public List<Medical> findByName(@RequestParam("name") String ListProductsName) throws Exception {
		System.out.println(ListProductsName);
		List<Medical> list= medicalService.findAll();
		List<Medical> filteredlist = list.stream().filter(m->m.getProductName().toLowerCase().contains(ListProductsName.toLowerCase())).collect(Collectors.toList());
//				.filter(m->m.getProductName().toLowerCase().contains(ListProductsName.toLowerCase()).collectors.tolist());
		
	    //List<ListProducts> list=productDAO.findByProductNameContaining(ListProductsName);
	    return filteredlist;
}
	
	
		
	

	}
