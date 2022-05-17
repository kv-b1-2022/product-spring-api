package com.ecommerceapp.dress.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="dresses")
public class DressProduct {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="category")
	private String category;
	
	
	private Integer price;

	@Column(name="image")
	private String image;

	
	}