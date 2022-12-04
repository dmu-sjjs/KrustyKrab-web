package js.krustykrab.dao;

import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order save(Order order);

    Optional<Order> findByOrderId(Long orderId);

    List<Order> findByUser(User user);

    List<Order> findByIsCompleted(Boolean isCompleted);

    List<Order> findAll();
}
