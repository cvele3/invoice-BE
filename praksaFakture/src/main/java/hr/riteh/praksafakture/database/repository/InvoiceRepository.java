package hr.riteh.praksafakture.database.repository;

import hr.riteh.praksafakture.database.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    @Query("SELECT MAX(ie.invoiceNumber) FROM InvoiceEntity ie")
    Long findMaxInvoiceNumber();
}
