package pl.pawpam.engineeringproject.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pawpam.engineeringproject.user.Role;
import pl.pawpam.engineeringproject.user.RoleRepository;
import pl.pawpam.engineeringproject.user.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service("adminService")
@Transactional//zapewnia nam transakcyjność w przypadku wykonywania wiecej niz jednego update, insertu itd.
public class AdminServiceImpl implements AdminService {//jesli jedna się nie powiedzie to druga tez nie zostanie uruchomiona lub wycofana

    @Qualifier("adminRepository")
    @Autowired
    private AdminRepository adminRepository;

    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;

    List<User> lisfOfUsers;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Autowired
//    private JpaContext jpaContext;

    public AdminServiceImpl() {
        lisfOfUsers = new ArrayList<>();
    }

//    @Override
//    public Page<User> findAll(Pageable pageable) {
//        Page<User> userList = adminRepository.findAll(pageable);
//        return userList;
//    }
    public List<User> getUsers()
    {
        lisfOfUsers = adminRepository.findAll();
        return lisfOfUsers;
    }

    @Override
    public User findUserById(int id) {
        User user = adminRepository.findUserById(id);
        return user;
    }

    @Override
    public void updateUser(int id, int nrRoli, int activity) {
        adminRepository.updateActivationUser(activity, id);
        adminRepository.updateRoleUser(nrRoli,id);
    }

    @Override
    public Page<User> findAllSearch(String param, Pageable pageable) {
        Page<User> userList = adminRepository.findAllSearch(param, pageable);
        return userList;
    }
//    @Override
//    public void insertInBatch(List<User> userList){
//        EntityManager em = jpaContext.getEntityManagerByManagedType(User.class);
//
//        for(int i = 0; i<userList.size(); i++){
//            User u = userList.get(i);
//            Role role = roleRepository.findByRole("ROLE_USER");
//            u.setRoles(new HashSet<Role>(Arrays.asList(role)));
//            u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
//            em.persist(u);
//            if(i % 50 == 0 && i > 0)
//            {
//                em.flush();
//                em.clear();
//                System.out.println("**** Załadowano " + i + " rekordów z " + userList.size());
//            }
//        }
//    }
//
//    public void saveAll(List<User> userList){
//        adminRepository.saveAll(userList);
//    }

}
