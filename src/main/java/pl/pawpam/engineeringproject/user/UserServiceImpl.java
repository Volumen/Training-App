package pl.pawpam.engineeringproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserServiceInterface {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;
    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Autowired
//    public UserServiceImpl(@Qualifier("userRepository")UserRepository userRepository,
//                       @Qualifier("roleRepository") RoleRepository roleRepository) {
//        this.userRepository=userRepository;
//        this.roleRepository=roleRepository;
//       // this.bCryptPasswordEncoder=bCryptPasswordEncoder;
//    }

    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);

        Role role = roleRepository.findByRole("ROLE_ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);

    }

    @Override
    public void updateUserPassword(String newPassword, String email) {

    }
//    @Override
//    public void updateUserPassword(String newPassword, String email) {
//        userRepository.updateUserPassword(bCryptPasswordEncoder.encode(newPassword), email);
//    }
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
