package com.kollu.springbootfiledata.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kollu.springbootfiledata.model.Product;
import com.kollu.springbootfiledata.repository.ProductRepository;
import com.kollu.springbootfiledata.util.ProductConstant;

@Service
public class CsvService {
	
	@Autowired
	private ProductRepository repository;

	// here, We are reading data by using OpenCSV concept

//	public void uploadData(MultipartFile file) throws Exception {
//		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//			CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(reader)
//											.withType(Product.class)
//											.withSeparator('|') //Added this line to read pipeline separated data
//											.withIgnoreLeadingWhiteSpace(true).build();
//
//			List<Product> products = csvToBean.parse();
//			repository.saveAll(products); // Persists to H2
//		}
//	}

//Here, We are reading data apache common CSV 

	public void uploadData(MultipartFile file) throws Exception {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			// 1. Read the header line once
			String headerLine = reader.readLine();
			if (headerLine == null)
				throw new RuntimeException("File is empty");

			// Auto-detect the comma OR pipeline separator
			char delimiter = headerLine.contains("|") ? '|' : ',';
			String fullContent = headerLine + "\n" + reader.lines().collect(Collectors.joining("\n"));
			StringReader stringReader = new StringReader(fullContent);

			CSVFormat format = CSVFormat.DEFAULT.builder()
					.setDelimiter(delimiter)
					.setHeader()
					.setSkipHeaderRecord(true)
					.setIgnoreHeaderCase(true)
					.setTrim(true)
					.build();

			try (CSVParser csvParser = new CSVParser(stringReader, format)) {
				List<Product> products = new ArrayList<>();

				for (CSVRecord record : csvParser) {
					try {
						products.add(mapToProduct(record, delimiter));
					} catch (Exception e) {
						System.out.println("Exception..");
					}
				}
				repository.saveAll(products);
			}
		}
	}

	private Product mapToProduct(CSVRecord record, char delimiter) {
		Product product = new Product();

		if (delimiter == '|') {
			product.setName(record.get(ProductConstant.PRODUCT_NAME));
			product.setPrice(Double.parseDouble(record.get(ProductConstant.PRODUCT_PRICE)));
			product.setQuantity(Integer.parseInt(record.get(ProductConstant.PRODUCT_QUANTITY)));
			product.setQuality(record.get(ProductConstant.PRODUCT_QUALITY)); 
		} else {
			//product.setName(record.get("name"));
			//product.setPrice(Double.parseDouble(record.get("price")));
		}

		return product;
	}
	
	
//fetch all data
	public List<Product> getAllProducts() {
		return repository.findAll(); // Performs SELECT * FROM PRODUCT
	}
	

	// Here, I am deleting uploaded file data before loading new file data
	public String clearDatabase() {
		repository.deleteAll(); // Executes DELETE FROM PRODUCT
		return "data deleted";
	}

}
