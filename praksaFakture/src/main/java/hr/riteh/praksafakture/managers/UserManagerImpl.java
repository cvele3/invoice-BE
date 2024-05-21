package hr.riteh.praksafakture.managers;


import com.nimbusds.jose.JOSEException;
import hr.riteh.praksafakture.database.entity.UserEntity;
import hr.riteh.praksafakture.services.UserService;
import hr.riteh.praksafakture.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;

    @Autowired
    public UserManagerImpl(UserService userService, BCryptPasswordEncoder passwordEncoder, JWTUtils jwtUtils) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public String registerUser(UserEntity userEntity) {
        boolean existingUser = userService.existsByUsername(userEntity.getUsername());
        if (existingUser) {
            return "User already exists";
        } else {
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userService.createNewUser(userEntity);
            return "User registered successfully";
        }
    }

    @Override
    public String loginUser(String username, String password) {
        UserEntity userEntity = userService.getUserByUsername(username);
        if (userEntity != null && passwordEncoder.matches(password, userEntity.getPassword())) {
            try {
                return jwtUtils.generateToken(userEntity.getUsername());
            } catch (JOSEException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "Invalid credentials";
        }
    }
}