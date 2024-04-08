package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.entity.InvoiceItemEntity;

import java.util.List;

public interface InvoiceItemService {

    void createInvoiceItem(InvoiceItemEntity invoiceItemEntity);

    void deleteInvoiceItemsByInvoiceId(Long invoiceId);

    List<InvoiceItemEntity> getAllInvoiceItemsFromInvoiceId(Long invoiceId);

    InvoiceItemEntity getInvoiceItem(Long invoiceItemId);
}
