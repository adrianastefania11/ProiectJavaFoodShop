package com.example.foodshop.controller;

import com.example.foodshop.domain.Invoice;
import com.example.foodshop.dto.InvoiceDto;
import com.example.foodshop.dto.InvoiceDto;
import com.example.foodshop.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/basket/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceWithBasket(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(invoiceService.getInvoiceWithBasket(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<InvoiceDto>> getAllInvoices() {
        return ResponseEntity
                .ok()
                .body(invoiceService.getAllInvoices());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteInvoice(@RequestParam Long id) {
        boolean deleted = invoiceService.deleteInvoice(id);

        if (deleted) {
            return ResponseEntity.ok().body("Invoice deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Invoice not found or could not be deleted");
        }
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateInvoice(@RequestParam Long id,
                                             @RequestBody Invoice invoice) {
        boolean updated = invoiceService.updateInvoice(id, invoice);
        if (updated) {
            return ResponseEntity.ok().body("invoice updated successfully");
        } else {
            return ResponseEntity.status(404).body("invoice not found or could not be updated");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto) {
        return ResponseEntity
                .ok()
                .body(invoiceService.createInvoice(invoiceDto));
    }
}
