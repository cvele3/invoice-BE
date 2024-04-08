package hr.riteh.praksafakture.database.repository;

import hr.riteh.praksafakture.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}