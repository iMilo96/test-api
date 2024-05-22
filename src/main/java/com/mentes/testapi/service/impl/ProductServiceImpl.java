package com.mentes.testapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentes.testapi.entities.ProductEntity;
import com.mentes.testapi.repositories.ProductRepository;
import com.mentes.testapi.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductEntity> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public ProductEntity createProduct(ProductEntity product) {
		ProductEntity productExist = productRepository.findOneByDescription(product.getDescription());
		if(productExist != null) {
			throw new RuntimeException("Description duplicate");
			
		}
		return productRepository.save(product);
	}

	@Override
	public ProductEntity updateProduct(Long id, ProductEntity product) {
		// TODO Auto-generated method stub
		ProductEntity productOriginal = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("not found id:" + id));
		productOriginal.setDescription(product.getDescription());
		productOriginal.setPrice(product.getPrice());
		return productRepository.save(productOriginal);
	}

	@Override
	public String deleteProduct(Long id) {
		ProductEntity productOriginal = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("not found id:" + id));
		productRepository.delete(productOriginal);
		return "product deleted id:" + id;
	}

	@Override
	public ProductEntity getProductById(Long id) {
		ProductEntity productOriginal = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("not found id:" + id));
		return productOriginal;
	}

}
