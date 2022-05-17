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
	@Data
	public class Menus {

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
		@Column(name="image_url")
		private String foodImages;

}
