package com.assessment.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.model.Invoice;
import com.assessment.model.LineItem;
import com.assessment.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository; 

	// Get all Invoices
	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}
	
	// Get Invoice by ID
	public Optional<Invoice> getInvoice(Long id) {		
		return invoiceRepository.findById(id);
	}
	
	//Save Invoice and LineItem
	public Invoice saveInvoice(Invoice invoice) {
		Set<LineItem> lineItems = invoice.getLineItem();
		invoice.setLineItem(lineItems);
		return invoiceRepository.save(invoice);
	}

}
