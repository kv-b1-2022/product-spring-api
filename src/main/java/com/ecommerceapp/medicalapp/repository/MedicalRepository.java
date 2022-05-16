package com.ecommerceapp.medicalapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceapp.medicalapp.model.Medical;









@Repository
public interface MedicalRepository extends JpaRepository<Medical,Integer>{
  
  //@Query("select u from com.medicalapp.medicalapi.controller.ListProducts u")
  //List<ListProducts> findAllProducts();
	

	
//  @Query ("select u from Student u where name like %ListProductsName%")
//	
//	List<ListProducts> findByName(String ListProductsName); 
  

	List<Medical> findByProductNameContaining(String listProductsName);
}
 

