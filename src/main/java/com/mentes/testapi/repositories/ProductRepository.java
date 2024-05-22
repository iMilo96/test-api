package com.mentes.testapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentes.testapi.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	public ProductEntity findOneByDescription(String description);
	
}
