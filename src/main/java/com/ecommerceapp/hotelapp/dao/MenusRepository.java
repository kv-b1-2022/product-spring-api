package com.ecommerceapp.hotelapp.dao;


	

	import java.util.List;
	import java.util.Optional;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;

import com.ecommerceapp.hotelapp.model.Menus;


	@Repository
	public interface MenusRepository extends JpaRepository<Menus, Integer> {

		Optional<Menus> findById(Integer id);

		@Query("select u from com.ecommerceapp.hotelapp.model.Menus u where u.price=:price")
		List<Menus> findByPrice(@Param("price") Integer price);

		@Query("select f from com.ecommerceapp.hotelapp.model.Menus f where f.foodName=:foodName")
		List<Menus> findByName(@Param("foodName") String foodName);

		@Query("select p from com.ecommerceapp.hotelapp.model.Menus p where p.price between 10 and 50")
		List<Menus> sortBetweenprice1();

		@Query("select p from com.ecommerceapp.hotelapp.model.Menus p where p.price between 51 and 150")
	    List<Menus> sortBetweenprice2();
		
		@Query("select p from com.ecommerceapp.hotelapp.model.Menus p where p.price between :min and :max")
		List<Menus> sortBetweenprice3(@Param("min") int min, @Param("max") int max);
		
		@Query("select t from com.ecommerceapp.hotelapp.model.Menus t where t.foodType=:foodType")
		List<Menus> findByCategory(String foodType);
		
		
		@Query("select S from com.ecommerceapp.hotelapp.model.Menus S where S.foodStyle=:foodStyle")
		List<Menus> findByStyle(String foodStyle);
		

		


	}



