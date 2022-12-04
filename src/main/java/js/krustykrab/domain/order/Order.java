package js.krustykrab.domain.order;

import js.krustykrab.domain.user.User;
import js.krustykrab.dto.order.OrderDto;
import js.krustykrab.dto.order.OrderMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long orderId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "address")
    private String address;

    @Column(name = "detailAddress")
    private String detailAddress;

    @Column(name = "orderDate")
    private String orderDate;

    @Column(name = "isCompleted")
    private Boolean isCompleted;

    public OrderDto toDto(){
        OrderDto orderDto = OrderMapper.mapper.orderEntityToDto(this);
        orderDto.setUserId(user.getUserId());
        return orderDto;
    }
}
