package hr.riteh.praksafakture.managers;

import hr.riteh.praksafakture.database.entity.InvoiceEntity;
import hr.riteh.praksafakture.requests.CreateInvoiceRequest;

public interface InvoiceManager {

    InvoiceEntity createInvoice(CreateInvoiceRequest request);

    void deleteInvoice(Long id);
}
