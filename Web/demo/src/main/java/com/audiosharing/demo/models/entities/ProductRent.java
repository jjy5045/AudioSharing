/*
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
@Table(name = "product_rent")
@DynamicUpdate
@DynamicInsert
public class ProductRent implements Serializable {
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long pro_detail_id;
	
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long pro_detail_id2;
	
	//복합키
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date rent_start_time;
	
	@Column(nullable = false, length = 20)
	private String rent_time;
	
	@Column(nullable = false, length = 20)
	private String rent_payment;
	
	@Column(nullable = false, length = 20)
	private String rent_add_payment;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0", length = 1)
	private boolean rent_pay_check;
	
	@Column(nullable = false, length = 20)
	private String rent_review_sound;
	
	@Column(nullable = false, length = 20)
	private String rent_review_fit;
	
	@Column(nullable = false, length = 20)
	private String rent_review_design;
	
	@Column(nullable = false, length = 20)
	private String rent_review_body;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0", length = 1)
	private boolean rent_review_check;
	
	
	

	
	@PrePersist
	protected void onCreate() {
		rent_start_time = Timestamp.valueOf(LocalDateTime.now());
	}
	
	
	@Builder
	public ProductRent(String rent_time, String rent_add_payment, String rent_review_sound, String rent_review_fit, 
			 String rent_review_design, String rent_review_body) {
		this.rent_time = rent_time;
	}
	
}
*/

