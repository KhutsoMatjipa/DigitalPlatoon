package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
