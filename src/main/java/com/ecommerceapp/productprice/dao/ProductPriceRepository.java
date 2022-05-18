package com.ecommerceapp.productprice.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerceapp.productprice.model.ProductPrice;



public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {

	@Query("select p from com.ecommerceapp.productprice.model.ProductPrice p where p.productId =:productId")
	Optional<ProductPrice> findByProductId(@Param("productId") int productId);

}
