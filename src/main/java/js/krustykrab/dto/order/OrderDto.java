package js.krustykrab.dto.order;

import js.krustykrab.domain.Store;
import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long orderId;
    private Long userId;
    private Long storeId;
    private String address;
    private String detailAddress;
    private String orderDate;
    private Boolean isCompleted;

    public OrderDto(Long userId, Long storeId, String address, String detailAddress, String orderDate, Boolean isCompleted) {
        this.userId = userId;
        this.storeId = storeId;
        this.address = address;
        this.detailAddress = detailAddress;
        this.orderDate = orderDate;
        this.isCompleted = isCompleted;
    }

    public Order toEntity(User user, Store store) {
        return Order.builder()
                .user(user)
                .store(store)
                .address(address)
                .detailAddress(detailAddress)
                .orderDate(orderDate)
                .isCompleted(isCompleted)
                .build();
    }
}
