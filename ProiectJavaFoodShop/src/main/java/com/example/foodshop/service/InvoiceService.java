package com.example.foodshop.service;
import com.example.foodshop.domain.Invoice;
import com.example.foodshop.dto.InvoiceDto;
import com.example.foodshop.exception.InvoiceNotFoundException;
import com.example.foodshop.mapper.InvoiceMapper;
import com.example.foodshop.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper invoiceMapper;

    public InvoiceDto getInvoiceWithBasket(Long id) {
        Optional<Invoice> invoice = Optional.ofNullable(invoiceRepository.findInvoiceById(id));

        if (invoice.isEmpty()) {
            throw new InvoiceNotFoundException("This invoice does not exist");
        }
        return invoiceMapper.mapToDto(invoice.get());
    }

    public List<InvoiceDto> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream().map(p -> invoiceMapper.mapToDto(p)).collect(Collectors.toList());

    }

    public boolean deleteInvoice(Long id) {
        boolean exists = invoiceRepository.existsById(id);

        if (!exists) {
            throw  new InvoiceNotFoundException("invoice with Id " + id + " does not exist");
        }
        else {
            invoiceRepository.deleteById(id);
            return true;

        }

    }
    @Transactional
    public boolean updateInvoice(Long  id, Invoice invoiceUpdate) {
        Invoice invoice = invoiceRepository.findInvoiceById(id);

        if(invoice != null)
        {
            if(invoiceUpdate.getBasket() != null){
                invoice.setBasket(invoiceUpdate.getBasket());
            }

            if(invoiceUpdate.getCreationDate() != null){
                invoice.setCreationDate(invoiceUpdate.getCreationDate());
            }

            if(invoiceUpdate.getTotalPrice() != null){
                invoice.setTotalPrice(invoiceUpdate.getTotalPrice());
            }
            return true;
        }
        else {
            return false;
        }

    }

    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        Invoice invoice = invoiceMapper.mapToEntity(invoiceDto);
        Invoice savedInvoice = invoiceRepository.save(invoice);

        return invoiceMapper.mapToDto(savedInvoice);
    }
}
