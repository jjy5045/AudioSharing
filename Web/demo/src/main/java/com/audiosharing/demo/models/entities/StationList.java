package com.audiosharing.demo.models.entities;

import java.io.Serializable;
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
@Table(name = "station_list")
@DynamicUpdate
@DynamicInsert
public class StationList implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, columnDefinition = "INT(11)")
	private Long stn_id;
	
	@Column(nullable = false, length = 45)
	private String stn_name;
	
	@Column(nullable = false, length = 45)
	private String stn_location;
	
	@Column(nullable = false, length = 45)
	private String stn_img;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date stn_createTimestamp;
	
	
	
	
	@PrePersist
	protected void onCreate() {
		stn_createTimestamp = Timestamp.valueOf(LocalDateTime.now());
	}
	
	
	@Builder
	public StationList(String stn_name, String stn_location, String stn_img) {
		this.stn_name = stn_name;
		this.stn_location = stn_location;
		this.stn_img = stn_img;
	}
}
