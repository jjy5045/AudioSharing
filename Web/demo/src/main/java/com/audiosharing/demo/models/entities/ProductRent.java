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
@Getter
@Setter
@Entity
@Table(name = "product_rent")
@DynamicUpdate
@DynamicInsert
public class ProductRent implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long rentId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date rentStartTime;

	@Column(nullable = false, length = 20)
	private String rentTime;

	@Column(nullable = false, length = 20)
	private String rentPayment;

	@Column(nullable = true, length = 20)
	private String rentAdditionalPayment;

	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0", length = 1)
	private boolean rentPayCheck;

	@Column(nullable = true, length = 20)
	private String rentReviewSound;

	@Column(nullable = true, length = 20)
	private String rentReviewFit;

	@Column(nullable = true, length = 20)
	private String rentReviewDesign;

	@Column(nullable = true, length = 20)
	private String rentReviewBody;

	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0", length = 1)
	private boolean rentReviewCheck;
	/*
	//제품 예약 확인
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1", length = 1)
	private boolean rentFinish;
	*/
	//예약 상태 확인
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0", length = 1)
	private boolean rentFinishCheck;

	@PrePersist
	protected void onCreate() {
		rentStartTime = Timestamp.valueOf(LocalDateTime.now());
	}
	

	// 유저 번호
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	// 제품 개별 번호
	@ManyToOne
	@JoinColumn(name = "proDetailId")
	private ProductDetail productDetail;

	@Builder
	public ProductRent(String rentTime, String rentPayment, String rentAdditionalPayment, 
			String rentReviewSound, String rentReviewFit,
			String rentReviewDesign, String rentReviewBody,
			User user, ProductDetail productDetail) {
		this.rentTime = rentTime;
		this.rentPayment = rentPayment;
		this.rentAdditionalPayment = rentAdditionalPayment;
		this.rentReviewSound = rentReviewSound;
		this.rentReviewFit = rentReviewFit;
		this.rentReviewDesign = rentReviewDesign;
		this.rentReviewBody = rentReviewBody;
		this.user = user;
		this.productDetail = productDetail;
	}

}
