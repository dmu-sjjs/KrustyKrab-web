package js.krustykrab.domain;

import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.Authority;
import js.krustykrab.domain.user.User;
import js.krustykrab.dto.order.OrderDto;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void toDtoTest() {
        User user = new User(99999L, "ADMIN", "ADMIN", "ADMIN", "ADMIN", "ADMIN", "ADMIN", Authority.USER);
        Order order = new Order(9999L, user, "ADDRESS", "D_ADDRESS", "20221231", false);

        OrderDto orderDto = order.toDto();
        System.out.println("orderDto.getOrderId() = " + orderDto.getOrderId());
        System.out.println("orderDto.getUserId() = " + orderDto.getUserId());
        System.out.println("orderDto.getAddress() = " + orderDto.getAddress());
        System.out.println("orderDto.getDetailAddress() = " + orderDto.getDetailAddress());
        System.out.println("orderDto.getIsCompleted() = " + orderDto.getIsCompleted());

    }
}