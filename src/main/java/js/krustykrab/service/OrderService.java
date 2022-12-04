package js.krustykrab.service;

import js.krustykrab.dao.OrderRepository;
import js.krustykrab.domain.cart.Cart;
import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.User;
import js.krustykrab.dto.order.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;

    public Order saveOrder(OrderDto orderDto) {
        User user = userService.findById(orderDto.getUserId()).toEntity();
        return orderRepository.save(orderDto.toEntity(user));
    }

    public OrderDto findOrderById(Long orderId) {
        return orderRepository.findByOrderId(orderId).orElseThrow().toDto();
    }
}
