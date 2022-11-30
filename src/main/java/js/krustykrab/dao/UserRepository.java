package js.krustykrab.dao;

import js.krustykrab.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByUserId(Long userId);

    Optional<User> findByIdAndPw(String id, String pw);

    List<User> findAll();
}
