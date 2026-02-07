package com.kollu.springbootfiledata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kollu.springbootfiledata.model.Product;
import com.kollu.springbootfiledata.service.CsvService;

@RestController
@RequestMapping("/csv")
public class CsvController {
	@Autowired
	private CsvService csvService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty())
			throw new RuntimeException("Please upload a file!");
		csvService.uploadData(file);
		return ResponseEntity.ok("File uploaded and data saved successfully.");
	}
	
	@GetMapping("/readfile")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = csvService.getAllProducts();
        return ResponseEntity.ok(products);
    }
	
	@DeleteMapping("/deletedata")
    public ResponseEntity<String> deleteData() {
        String resp = csvService.clearDatabase();
        return ResponseEntity.ok(resp);
    }
	
	
}
