package com.audiosharing.demo.models.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
@Table(name = "product_list")
@DynamicUpdate
@DynamicInsert
public class ProductList implements Serializable {
	//제품 목록 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long pro_list_id;
	
	//제품 타입
	@Column(nullable = false, length = 45)
	private String pro_list_type;
	
	//제품 이름
	@Column(nullable = false, length = 45)
	private String pro_list_name;
	
	//제품 회사
	@Column(nullable = false, length = 45)
	private String pro_list_company;
	
	//제품 설명
	@Column(nullable = false, length = 45)
	private String pro_list_text;
	
	//제품 가격
	@Column(nullable = false, length = 45)
	private String pro_list_price;
	
	//제품 이용 가격
	@Column(nullable = false, length = 45)
	private String pro_list_rent_price;
	
	
	
	@Builder
	public ProductList(String pro_list_type, String pro_list_name, String pro_list_company, String pro_list_text,
			String pro_list_price, String pro_list_rent_price) {
		this.pro_list_type = pro_list_type;
		this.pro_list_name = pro_list_name;
		this.pro_list_company = pro_list_company;
		this.pro_list_text = pro_list_text;
		this.pro_list_price = pro_list_price;
		this.pro_list_rent_price = pro_list_rent_price;
		
	}
}
