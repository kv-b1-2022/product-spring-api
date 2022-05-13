package com.ecommerceapp.productprice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerceapp.productprice.model.ProductPrice;



public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {

	@Query("select p from com.ecommerceapp.productprice.model.ProductPrice p where p.productId = ?1 and p.endDate is null")
	Optional<ProductPrice> findByProductId(Integer productId);

}
