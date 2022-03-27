package com.audiosharing.demo.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.ProductDetail;
import com.audiosharing.demo.models.entities.ProductList;
import com.audiosharing.demo.models.entities.User;
import com.audiosharing.demo.models.values.ProductDetailValue;
import com.audiosharing.demo.repositories.ProductDetailRepository;
import com.audiosharing.demo.repositories.ProductListRepository;

import java.util.List;

@Service
public class ProductListService {
	private final ProductListRepository productListRepository;
	
	@Autowired
	public ProductListService(ProductListRepository productListRepository) {
		this.productListRepository = productListRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<ProductList> findByProListId(Long id) {
		return productListRepository.findByProListId(id);
	}
	
}
