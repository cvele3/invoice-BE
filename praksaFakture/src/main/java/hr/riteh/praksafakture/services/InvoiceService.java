package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.entity.InvoiceEntity;

import java.util.List;

public interface InvoiceService {

    InvoiceEntity createInvoice(InvoiceEntity invoiceEntity);

    Long getInvoiceNumber();

    void deleteInvoice(Long id);

    List<InvoiceEntity> getAllInvoices();

    InvoiceEntity getInvoiceById(Long id);
}
