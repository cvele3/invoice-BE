package hr.riteh.praksafakture.managers;

import hr.riteh.praksafakture.database.entity.InvoiceEntity;
import hr.riteh.praksafakture.requests.CreateInvoiceRequest;

import java.io.ByteArrayInputStream;

public interface InvoiceManager {

    InvoiceEntity createInvoice(CreateInvoiceRequest request);

    void deleteInvoice(Long id);

    ByteArrayInputStream invoiceToExcel(Long id);

    ByteArrayInputStream allInvoicesToExcel(String username);
}
