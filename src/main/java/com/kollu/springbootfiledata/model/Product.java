package com.kollu.springbootfiledata.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//	@CsvBindByName(column = "PRODUCT_NAME")
	@Column(name = "PRODUCT_NAME")
	private String name;

	//	@CsvBindByName(column = "PRODUCT_PRICE")
	@Column(name = "PRODUCT_PRICE")
	private Double price;
	
	@Column(name = "PRODUCT_QUANTITY")
	private int quantity;
	
	@Column(name = "PRODUCT_QUALITY")
	private String quality;
}
