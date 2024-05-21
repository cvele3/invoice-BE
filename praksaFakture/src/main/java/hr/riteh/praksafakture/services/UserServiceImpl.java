package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.entity.UserEntity;
import hr.riteh.praksafakture.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createNewUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findById(username).orElseThrow(() -> new IllegalArgumentException("User with username: " + username + " not found"));
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsById(username);
    }
}
