package com.ecommerceapp.cakes.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ecommerceapp.cakes.model.ListOfCakes;
@Component
@Repository
public interface CakeRepository extends JpaRepository<ListOfCakes,Integer>{

}