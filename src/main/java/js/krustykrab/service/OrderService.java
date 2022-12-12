package js.krustykrab.service;

import js.krustykrab.dao.OrderRepository;
import js.krustykrab.domain.Store;
import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.User;
import js.krustykrab.dto.order.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final StoreService storeService;

    public Order saveOrder(OrderDto orderDto, Long storeId) {
        User user = userService.findById(orderDto.getUserId()).toEntity();
        Store store = storeService.findStoreById(storeId).toHasIdEntity();
        Order order = orderDto.toEntity(user, store);
        return orderRepository.save(order);
    }

    public List<OrderDto> findAllOrder() {
        return orderRepository.findAll().stream()
                .map(order -> order.toDto())
                .collect(Collectors.toList());
    }

    public OrderDto findOrderById(Long orderId) {
        return orderRepository.findByOrderId(orderId).orElseThrow().toDto();
    }
}
