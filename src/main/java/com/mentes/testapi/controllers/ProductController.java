package com.mentes.testapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentes.testapi.entities.ProductEntity;
import com.mentes.testapi.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List <ProductEntity> getAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/{id}")
	public ProductEntity getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	} 
	@PostMapping
	public ProductEntity createProduct(@RequestBody ProductEntity product) {
		return productService.createProduct(product);
			
	}
	
	@PutMapping("/{id}")
	public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity product) {
		return productService.updateProduct(id,product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
		
	}

}
