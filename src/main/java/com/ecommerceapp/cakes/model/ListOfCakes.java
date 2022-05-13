package com.ecommerceapp.cakes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="listcake")
public class ListOfCakes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREAMENT
	@Column (name="id")
	private int id;
	private String name;
	private String brand;
	private String category;
	private String price;
	private String image;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getbrand() {
		return brand;
	}
	public void setbrand(String brand) {
		this.brand = brand;
	}
	public String getcategory() {
		return category;
	}
	public void setcategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getimage() {
		return image;
	}
	public void setimage(String image) {
		this.image = image;
	}
	
	

}
