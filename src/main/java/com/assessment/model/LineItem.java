package com.assessment.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "line_item")
public class LineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="line_item_id")
	private Long id;
	
	private Long quantity;
	
	private String description;
	
	private BigDecimal unitPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="invoice_id")
	@JsonBackReference
	private Invoice invoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Invoice saveAll(Invoice invoice2) {
		
		return null;
	}
}
