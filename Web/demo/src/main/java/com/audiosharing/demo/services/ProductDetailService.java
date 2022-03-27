package com.audiosharing.demo.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.ProductDetail;
import com.audiosharing.demo.models.entities.ProductList;
import com.audiosharing.demo.models.values.ProductDetailValue;
import com.audiosharing.demo.models.values.ProductListValue;
import com.audiosharing.demo.repositories.ProductDetailRepository;
import com.audiosharing.demo.repositories.ProductListRepository;

import java.util.List;

@Service
public class ProductDetailService {
	private final ProductDetailRepository productDetailRepository;
	
	private final ProductListRepository productListRepository;
	
	@Autowired
	public ProductDetailService(ProductDetailRepository productDetailRepository) {
		this.productDetailRepository = productDetailRepository;
	}
	
	@Autowired
	public ProductListRepository(ProductListRepository productListRepository) {
		this.productListRepository = productListRepository;
	}
	
	
	@Transactional
	public List<ProductDetail> findAll() {
		List<ProductDetail> ProductDetailList = this.productDetailRepository.findAll();
		return ProductDetailList;
	}
	
	@Transactional
	public ProductDetail save(ProductDetailValue value) {
		//long a = value.getProListId();
		//if(productListRepository.findByProListId(value.getProListId())) 
		
		if(productListRepository.findByProListId(value.getProListId()) != null)
		{
			ProductDetail productDetail = ProductDetail.builder()
					.productList(productListRepository. findByProListId(value.getProListId()).get())
					.proDetailNumber(value.getProDetailNumber())
					.proDetailQR(value.getProDetailQR()).build();
			
			return productDetailRepository.save(productDetail);
		} else {
			return null;
		}
		
		/*
		ProductDetail productDetail = ProductDetail.builder()
				.proDetailNumber(value.getProDetailNumber())
				.proDetailQR(value.getProDetailQR()).build();
		
		return productDetailRepository.save(productDetail);
		*/
	}
}
