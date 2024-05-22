package com.mentes.testapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mentes.testapi.entities.ProductEntity;

@Service
public interface ProductService {
	
	public List <ProductEntity> getProducts();
	
	public ProductEntity createProduct(ProductEntity product);

	public ProductEntity updateProduct(Long id, ProductEntity product);

	public String deleteProduct(Long id);

	public ProductEntity getProductById(Long id);
}

