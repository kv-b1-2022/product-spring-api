package com.ecommerceapp.productprice.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product_price")
public class ProductPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT
	@Column(name = "id")
	private Integer id;

	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private Integer price;

	@Column(name = "start_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@Column(name = "end_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate EndDate;

}
