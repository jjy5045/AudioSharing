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
	private Long proList_id;
	
	//제품 타입
	@Column(nullable = false, length = 45)
	private String proList_type;
	
	//제품 이름
	@Column(nullable = false, length = 45)
	private String proList_name;
	
	//제품 회사
	@Column(nullable = false, length = 45)
	private String proListCompany;
	
	//제품 설명
	@Column(nullable = false, length = 45)
	private String proListText;
	
	//제품 가격
	@Column(nullable = false, length = 45)
	private String proListPrice;
	
	//제품 이용 가격
	@Column(nullable = false, length = 45)
	private String proListRentPrice;
	
	
	
	@Builder
	public ProductList(String proList_type, String proList_name, String proListCompany, String proListText,
			String proListPrice, String proListRentPrice) {
		this.proList_type = proList_type;
		this.proList_name = proList_name;
		this.proListCompany = proListCompany;
		this.proListText = proListText;
		this.proListPrice = proListPrice;
		this.proListRentPrice = proListRentPrice;
		
	}
}
