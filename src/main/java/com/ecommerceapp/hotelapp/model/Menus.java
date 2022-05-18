package com.ecommerceapp.hotelapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@ToString
@Table(name = "menu_list")
//@Data
public class Menus {

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodStyle() {
		return foodStyle;
	}
	public void setFoodStyle(String foodStyle) {
		this.foodStyle = foodStyle;
	}
	public String getFoodImages() {
		return foodImages;
	}
	public void setFoodImages(String foodImages) {
		this.foodImages = foodImages;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "food_name", nullable = false, unique = true, length = 50)
	private String foodName;

	@Column(name = "price", nullable = false)
	private int price;

	@Column(name = "food_type")
	private String foodType;

	@Column(name = "style_of_items")
	private String foodStyle;
	@Column(name = "image_url")
	private String foodImages;

}
