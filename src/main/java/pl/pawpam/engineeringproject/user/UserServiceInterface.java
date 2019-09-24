package pl.pawpam.engineeringproject.user;

public interface UserServiceInterface {
    User findUserByEmail(String email);
    void saveUser(User user);

}
