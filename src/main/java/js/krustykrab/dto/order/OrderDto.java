package js.krustykrab.dto.order;

import js.krustykrab.domain.Order;
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
}
