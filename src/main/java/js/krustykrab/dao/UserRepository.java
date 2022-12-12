package js.krustykrab.dao;

import js.krustykrab.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByUserId(Long userId);

    Optional<User> findByIdAndPw(String id, String pw);

    @Modifying
    @Query("UPDATE User u SET u.username = ?2, u.address = ?3, u.detailAddress = ?4, u.phoneNumber = ?5 WHERE u.userId = ?1")
    Integer changeUserData(Long userId, String username, String address, String detailAddress, String phoneNumber);

    List<User> findAll();
}
