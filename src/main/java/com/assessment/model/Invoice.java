package com.assessment.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id")
	private Long id;

	private String client;

	private Long vatRate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm a")
	@CreationTimestamp
	private Date invoiceDate;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "invoice")
	@JsonManagedReference
	private Set<LineItem> lineItem = new HashSet<>();

	public Set<LineItem> getLineItem() {
		return lineItem;
	}

	public void setLineItem(Set<LineItem> lineItem) {
		this.lineItem = lineItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Long getVatRate() {
		return vatRate;
	}

	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public BigDecimal getSubTotal() {
		BigDecimal lineItemTotal = new BigDecimal(0);

		for (LineItem myClass : lineItem) {
			lineItemTotal = myClass.getLineItemTotal();
		}

		return lineItemTotal;
	}

	public BigDecimal getVat() {

		BigDecimal vatAmount = new BigDecimal(0);

		BigDecimal lineItemTotal = new BigDecimal(0);

		double vatRatePercentage = ((double) vatRate / 100);

		for (LineItem myClass : lineItem) {
			myClass.getLineItemTotal();
			lineItemTotal = myClass.getLineItemTotal();
			BigDecimal vatRatePercentageToBigDecimal = new BigDecimal(vatRatePercentage);
			vatAmount = lineItemTotal.multiply(vatRatePercentageToBigDecimal).setScale(2, RoundingMode.HALF_UP);
		}

		return vatAmount;
	}

	public BigDecimal getTotal() {
		BigDecimal lineItemTotal = new BigDecimal(0);
		BigDecimal total = new BigDecimal(0);

		for (LineItem myClass : lineItem) {
			BigDecimal vatAmount = getVat();
			myClass.getLineItemTotal();
			lineItemTotal = myClass.getLineItemTotal();
			total = vatAmount.add(lineItemTotal);
		}

		return total;
	}

}
