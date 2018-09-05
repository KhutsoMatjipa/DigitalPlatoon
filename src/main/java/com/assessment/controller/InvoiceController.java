package com.assessment.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.model.Invoice;
import com.assessment.repository.InvoiceRepository;
import com.assessment.service.InvoiceService;

@RestController
@RequestMapping("/api")
public class InvoiceController {

	/*
	 * @Autowired LineItem lineItemService;
	 */

	@Autowired
	InvoiceService invoiceService;

	@Autowired
	InvoiceRepository invoiceRepository;

	/**
	 * Save Invoice
	 */
	@PostMapping(value = "/invoice")
	public Invoice addInvoice(@Valid @RequestBody Invoice invoice) {
		
		return invoiceService.saveInvoice(invoice);

	}

	/**
	 * Get all Invoices
	 * 
	 * @return Invoice
	 */
	@GetMapping("/invoices")
	public List<Invoice> viewAllInvoice() {
		return invoiceService.getAllInvoices();
	}

	/**
	 * Get a Invoice by ID
	 * 
	 * @return Invoice
	 */ 
	@GetMapping("/invoice/{id}")
	public Optional<Invoice> viewInvoice(@PathVariable("id") final Long id) {
		return invoiceService.getInvoice(id);
	}

}
