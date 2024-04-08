package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.entity.InvoiceItemEntity;
import hr.riteh.praksafakture.database.repository.InvoiceItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class InvoiceItemServiceImpl implements InvoiceItemService{

    private final InvoiceItemRepository invoiceItemRepository;

    @Autowired
    public InvoiceItemServiceImpl(InvoiceItemRepository invoiceItemRepository) {
        this.invoiceItemRepository = invoiceItemRepository;
    }

    @Override
    public void createInvoiceItem(InvoiceItemEntity invoiceItemEntity) {
        log.info("Creating invoice item");
        invoiceItemRepository.save(invoiceItemEntity);
    }

    @Override
    public void deleteInvoiceItemsByInvoiceId(Long invoiceId) {
        log.info("Deleting invoice items by invoice id");
        invoiceItemRepository.deleteInvoiceItemsByInvoiceId(invoiceId);
    }

    @Override
    public List<InvoiceItemEntity> getAllInvoiceItemsFromInvoiceId(Long invoiceId) {
        log.info("Getting all invoice items from invoice id");
        return invoiceItemRepository.findAllByInvoiceId(invoiceId);
    }

    @Override
    public InvoiceItemEntity getInvoiceItem(Long invoiceItemId) {
        log.info("Getting invoice item");
        return invoiceItemRepository.findById(invoiceItemId)
            .orElseThrow(() -> new IllegalArgumentException("Invoice item with id: " + invoiceItemId + " does not exist"));
    }
}
