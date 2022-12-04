package js.krustykrab.dto.order;

import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDto {

    private Long orderId;
    private Long userId;
    private String address;
    private String detailAddress;
    private String orderDate;
    private Boolean isCompleted;

    public OrderDto(Long userId, String address, String detailAddress, String orderDate, Boolean isCompleted) {
        this.userId = userId;
        this.address = address;
        this.detailAddress = detailAddress;
        this.orderDate = orderDate;
        this.isCompleted = isCompleted;
    }

    public Order toEntity(User user) {
        return Order.builder()
                .user(user)
                .address(address)
                .detailAddress(detailAddress)
                .orderDate(orderDate)
                .isCompleted(isCompleted)
                .build();
    }
}
