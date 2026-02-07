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
	@Column(name = "Product_Name")
	private String name;
//	@CsvBindByName(column = "PRODUCT_PRICE")
	@Column(name = "Product_Price")
	private Double price;
}
