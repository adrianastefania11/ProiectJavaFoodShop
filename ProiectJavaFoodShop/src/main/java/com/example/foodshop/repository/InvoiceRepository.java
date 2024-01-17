package com.example.foodshop.repository;

import com.example.foodshop.domain.Invoice;
import com.example.foodshop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAll();
    Invoice findInvoiceById(Long id);
    Invoice save(Invoice saved);
}
