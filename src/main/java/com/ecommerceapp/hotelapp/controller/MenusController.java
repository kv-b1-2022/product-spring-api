package com.ecommerceapp.hotelapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapp.hotelapp.dao.MenusRepository;
import com.ecommerceapp.hotelapp.model.Menus;

@RestController
public class MenusController {
	@Autowired
	MenusRepository menuRepository;

	@PostMapping("MenuInsert/save")

	public void save(@RequestBody Menus menulist) {

		menuRepository.save(menulist);
	}

	@GetMapping("MenuList/list")
	public List<Menus> findAll() {

		List<Menus> list = menuRepository.findAll();

		return list;

	}

	@DeleteMapping("MenuDelete/{id}")

	public void delete(@PathVariable("id") Integer id) {

		menuRepository.deleteById(id);

	}

	@PutMapping("Menuupdate/{id}")

	public void update(@PathVariable("id") Integer id, @RequestBody Menus menulist) {

		menulist.setId(id);

		menuRepository.save(menulist);
	}

	@GetMapping("MenuById/{id}")

	public Optional<Menus> findById(@PathVariable("id") Integer id) {

		Optional<Menus> m = menuRepository.findById(id);
		return m;
	}

	@GetMapping("MenuFindPrice/{price}") // find by less than price
	public List<Menus> findByPrice(@PathVariable("price") Integer price) {
		List<Menus> menuPrice = menuRepository.findByPrice(price);
		return menuPrice;
	}

	@GetMapping("FindMenuByName/{food_name}")
	public List<Menus> findByName(@PathVariable("food_name") String foodName) {
		List<Menus> menuName = menuRepository.findByName(foodName);
		System.out.println("foodName");
		return menuName;
	}

	@GetMapping("DishesByLetter/food_name")
	public List<Menus> dishesByLetter(@RequestParam("food_name") String foodName) {
		List<Menus> menus = menuRepository.findAll();
		List<Menus> filteredMenus = menus.stream()
				.filter(food -> food.getFoodName().toLowerCase().contains(foodName.toLowerCase()))
				.collect(Collectors.toList());
		System.out.println(filteredMenus);
		return filteredMenus;
	}

	@GetMapping("SortBetweenprice/price1") // find by less than price
	public List<Menus> sortBetweenprice1() {
		List<Menus> prices1 = menuRepository.sortBetweenprice1();
		return prices1;
	}

	@GetMapping("SortBetweenprice/price2") // find by less than price
	public List<Menus> sortBetweenprice2() {
		List<Menus> prices2 = menuRepository.sortBetweenprice2();
		return prices2;
	}

	@GetMapping("SortBetweenprice/price") // find by less than price given by user
	public List<Menus> sortBetweenprice3(@RequestParam("min") int min, @RequestParam("max") int max) {
		List<Menus> prices3 = menuRepository.sortBetweenprice3(min, max);
		return prices3;
	}

	@GetMapping("findBycategory")
	public List<Menus> findByCategory(@RequestParam("foodType") String foodType) {
		System.out.println("hello");
		List<Menus> menuCategory = menuRepository.findByCategory(foodType);
		return menuCategory;
	}

	@GetMapping("findByStyle/{style_of_items}")
	public List<Menus> findByStyle(@PathVariable("style_of_items") String foodStyle) {
		List<Menus> menuStyle = menuRepository.findByStyle(foodStyle);
		return menuStyle;

	}
//		@GetMapping("foods/FindMenuByCategory/{veg}")
//		public List<Menus> findByCategory1(@PathVariable("veg") String foodType) {
//			List<Menus> menuType = menuRepository.findByName(foodType);
//			System.out.println("foodType");
//			return menuType;
//	
//	}
}
