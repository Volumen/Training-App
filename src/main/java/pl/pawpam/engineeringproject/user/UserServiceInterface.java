package pl.pawpam.engineeringproject.user;

import java.util.List;

public interface UserServiceInterface {
    User findUserByEmail(String email);
    void saveUser(User user);
    public void updateUserPassword(String newPassword, String email);
    List<User> findAll();

}
