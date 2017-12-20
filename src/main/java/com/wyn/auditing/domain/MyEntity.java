package com.wyn.auditing.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.wyn.auditing.AuditListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditListener.class)
public class MyEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private String description;
	
	private BigDecimal price;
	
	private String imageUrl;

}
