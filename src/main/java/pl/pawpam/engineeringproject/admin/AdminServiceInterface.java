package pl.pawpam.engineeringproject.admin;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pawpam.engineeringproject.user.User;

import java.util.List;

public interface AdminServiceInterface {
    //Page<User> findAll(Pageable pageable);
    List<User> getUsers();
    User findUserById(long id);
    void updateUser(int id, int nrRole, int activity);
    Page<User> findAllSearch(String param, Pageable pageable);
    void deleteUser(long id);
}
