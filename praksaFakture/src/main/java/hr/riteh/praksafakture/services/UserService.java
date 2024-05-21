package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.entity.UserEntity;

public interface UserService {
    UserEntity createNewUser(UserEntity userEntity);
    UserEntity getUserByUsername(String username);
    boolean existsByUsername(String username);
}
