package js.krustykrab.dao;

import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.order.OrderDetail;
import js.krustykrab.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetail> findByUser(User user);

    List<OrderDetail> findByOrder(Order Order);

    List<OrderDetail> findAll();
}
