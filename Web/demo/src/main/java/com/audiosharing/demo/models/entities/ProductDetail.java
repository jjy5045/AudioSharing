package com.audiosharing.demo.models.entities;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "product_detail")
@DynamicUpdate
@DynamicInsert
public class ProductDetail implements Serializable {
	//제품 개별 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long pro_detail_id;
	
	//제품 개별 일련 번호
	@Column(nullable = false, length = 50)
	private String pro_detail_number;
	
	//제품 개별 QR 코드
	@Column(nullable = false, length = 100)
	private String pro_detail_QR;
	
	//제품 개별 등록 날짜
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date pro_detail_date;
	
	//제품 목록 번호
	@ManyToOne
	@JoinColumn(name="pro_list_id")
    private ProductList productList;
	
	//스테이션 번호
	@OneToOne
	@JoinColumn(name="stn_id")
	private StationList stationList;
	

	
	@PrePersist
	protected void onCreate() {
		pro_detail_date = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@Builder
	public ProductDetail(String pro_detail_number, String pro_detail_QR, String pro_detail_date) {
		this.pro_detail_number = pro_detail_number;
		this.pro_detail_QR = pro_detail_QR;
	}

}