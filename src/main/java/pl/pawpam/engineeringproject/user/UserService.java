package pl.pawpam.engineeringproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements UserServiceInterface {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;
    //@Autowired
   // private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(user.getPassword());

        userRepository.save(user);

    }
}
