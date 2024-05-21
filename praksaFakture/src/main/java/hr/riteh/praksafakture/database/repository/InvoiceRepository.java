package hr.riteh.praksafakture.database.repository;

import hr.riteh.praksafakture.database.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    @Query("SELECT MAX(ie.invoiceNumber) FROM InvoiceEntity ie")
    Long findMaxInvoiceNumber();

    @Query("SELECT ie FROM InvoiceEntity ie WHERE ie.customerUsername = ?1")
    List<InvoiceEntity> findInvoicesByUsername(String username);
}
