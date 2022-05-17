package com.ecommerceapp.Groceries.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceapp.Groceries.model.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}



