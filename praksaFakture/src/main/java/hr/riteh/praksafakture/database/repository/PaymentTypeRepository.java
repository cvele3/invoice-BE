package hr.riteh.praksafakture.database.repository;

import hr.riteh.praksafakture.database.entity.PaymentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentTypeEntity, Long> {
}