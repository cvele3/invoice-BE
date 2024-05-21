package hr.riteh.praksafakture.database.repository;

import hr.riteh.praksafakture.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
