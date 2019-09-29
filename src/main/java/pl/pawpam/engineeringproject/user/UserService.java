package pl.pawpam.engineeringproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(@Qualifier("userRepository")UserRepository userRepository,
                       @Qualifier("roleRepository") RoleRepository roleRepository) {
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
       // this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(user.getPassword());
        user.setActive(1);

        Role role = roleRepository.findByRole("ROLE_ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);

    }
}
