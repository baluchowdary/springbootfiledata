package com.kollu.springbootfiledata.model;



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
	private String name;
//	@CsvBindByName(column = "PRODUCT_PRICE")
	private Double price;
}
