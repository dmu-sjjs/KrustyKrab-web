package js.krustykrab.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderDetailDto {
    private Long orderDetailId;
    private Long orderId;
    private Long userId;
    private Long menuId;
}
