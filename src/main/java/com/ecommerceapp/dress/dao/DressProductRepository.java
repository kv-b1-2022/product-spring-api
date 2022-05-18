package com.ecommerceapp.dress.dao;

import com.ecommerceapp.dress.model.DressProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DressProductRepository extends JpaRepository<DressProduct,Integer> {
}

