package com.kollu.springbootfiledata.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kollu.springbootfiledata.model.Product;
import com.kollu.springbootfiledata.repository.ProductRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class CsvService {
	@Autowired
	private ProductRepository repository;

	public void uploadData(MultipartFile file) throws Exception {
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(reader)
											.withType(Product.class)
											.withSeparator('|') //Added this line to read pipeline separated data
											.withIgnoreLeadingWhiteSpace(true).build();

			List<Product> products = csvToBean.parse();
			repository.saveAll(products); // Persists to H2
		}
	}
	
	public List<Product> getAllProducts() {
        return repository.findAll(); // Performs SELECT * FROM PRODUCT
    }
	
	//Here, I am deleting uploaded file data before loading new file data
	public String clearDatabase() {
	    repository.deleteAll(); // Executes DELETE FROM PRODUCT
	    return "data deleted";
	}
	
}
