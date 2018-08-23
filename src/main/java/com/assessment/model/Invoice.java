package com.assessment.model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "invoice")
public class Invoice {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="invoice_id")
		private Long id;
		
		private String client;
		
		private Long vatRate;
		
		@Column(nullable = false, updatable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@CreationTimestamp
		private Date invoiceDate;
		
		@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true,
					mappedBy = "invoice")
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
		

}
