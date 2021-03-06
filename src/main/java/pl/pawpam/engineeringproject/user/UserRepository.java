package pl.pawpam.engineeringproject.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    //@Query("select u from User u where u.email = ?1")
    User findByEmail(String email);


//    @Modifying
//    @Query("UPDATE User u SET u.password = :newPassword WHERE u.email= :email")
//    void updateUserPassword(@Param("newPassword") String password, @Param("email") String email);
//
//    @Modifying
//    @Query("UPDATE User u SET u.name = :newName, u.lastName = :newLastName, u.email = :newEmail WHERE u.id= :id")
//    void updateUserProfile(@Param("newName") String newName, @Param("newLastName") String newLastName,
//                           @Param("newEmail") String newEmail, @Param("id") Integer id);

//    @Modifying
//    @Query("UPDATE User u SET  u.id = :newId  WHERE u.email= :email")
//    void updateUserId(@Param("id") Integer newId, @Param("email") String email);

}
