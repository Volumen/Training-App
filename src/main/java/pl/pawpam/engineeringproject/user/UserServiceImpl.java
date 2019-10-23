package pl.pawpam.engineeringproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserServiceInterface {


//    @Qualifier("userRepository")
//    @Autowired
    private UserRepository userRepository;
//    @Qualifier("roleRepository")
//    @Autowired
    private RoleRepository roleRepository;

    //@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(@Qualifier("userRepository")UserRepository userRepository,
                       @Qualifier("roleRepository") RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;

    }

    // private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);

        Role role = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);

    }
//    @Override
//    public List<User> findAll()
//    {
//        List<User> userList = userRepository.findAll();
//        return userList;
//    }

    @Override
    public void updateUserPassword(String newPassword, String email) {

    }

    @Override
    public List<User> findAll() {
        return null;
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
