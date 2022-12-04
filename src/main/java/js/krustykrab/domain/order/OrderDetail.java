package js.krustykrab.domain.order;

import js.krustykrab.domain.menu.Menu;
import js.krustykrab.domain.user.User;
import js.krustykrab.dto.order.OrderDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_DETAIL")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDetailId")
    private Long orderDetailId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "menuId")
    private Menu menu;

    @Column(name = "count")
    private int count;

    public OrderDetail(Order order, User user, Menu menu, int count) {
        this.order = order;
        this.user = user;
        this.menu = menu;
        this.count = count;
    }

    public OrderDetailDto toDto() {
        return OrderDetailDto.builder()
                .orderDetailId(orderDetailId)
                .orderId(order.getOrderId())
                .userId(user.getUserId())
                .menuId(menu.getMenuId())
                .count(count)
                .build();
    }

}
