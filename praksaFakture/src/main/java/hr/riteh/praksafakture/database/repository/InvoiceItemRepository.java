package hr.riteh.praksafakture.database.repository;

import hr.riteh.praksafakture.database.entity.InvoiceItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItemEntity, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM InvoiceItemEntity i WHERE i.invoice.id = ?1")
    void deleteInvoiceItemsByInvoiceId(Long invoiceId);

    @Query("SELECT i FROM InvoiceItemEntity i WHERE i.invoice.id = ?1")
    List<InvoiceItemEntity> findAllByInvoiceId(Long invoiceId);
}