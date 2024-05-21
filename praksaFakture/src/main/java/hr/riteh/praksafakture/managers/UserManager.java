package hr.riteh.praksafakture.managers;

import hr.riteh.praksafakture.database.entity.UserEntity;

public interface UserManager {
    String registerUser(UserEntity userEntity);

    String loginUser(String username, String password);
}