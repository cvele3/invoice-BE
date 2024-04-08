package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.entity.InvoiceEntity;
import hr.riteh.praksafakture.database.repository.InvoiceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public InvoiceEntity createInvoice(InvoiceEntity invoiceEntity) {
        log.info("Creating invoice with invoice number: {}", invoiceEntity.getInvoiceNumber());
        return invoiceRepository.save(invoiceEntity);
    }

    @Override
    public Long getInvoiceNumber() {
        log.info("Getting next invoice number");
        return invoiceRepository.findMaxInvoiceNumber() + 1;
    }

    @Override
    public void deleteInvoice(Long id) {
        log.info("Deleting invoice with id: {}", id);
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<InvoiceEntity> getAllInvoices() {
        log.info("Getting all invoices");
        return invoiceRepository.findAll();
    }

    @Override
    public InvoiceEntity getInvoiceById(Long id) {
        log.info("Getting invoice by id: {}", id);
        return invoiceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invoice with id: " + id + " does not exist"));
    }
}
