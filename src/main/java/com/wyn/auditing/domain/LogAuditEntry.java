package com.wyn.auditing.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class LogAuditEntry {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private BigDecimal price;
	private String imageUrl;
	private String methodAction;
}
