package js.krustykrab.domain.order;

import js.krustykrab.domain.menu.Menu;
import js.krustykrab.domain.user.User;
import js.krustykrab.dto.order.OrderDetailDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Entity
@NoArgsConstructor
@Table(name = "ORDER_DETAIL")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDetailId")
    private Long orderDetailId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "menuId")
    private Menu menu;

    public OrderDetail(Order order, User user, Menu menu) {
        this.order = order;
        this.user = user;
        this.menu = menu;
    }

    public OrderDetailDto toDto() {
        return OrderDetailDto.builder()
                .orderDetailId(orderDetailId)
                .orderId(order.getOrderId())
                .userId(user.getUserId())
                .menuId(menu.getMenuId())
                .build();
    }

}
