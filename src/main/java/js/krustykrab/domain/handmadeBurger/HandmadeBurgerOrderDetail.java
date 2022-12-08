package js.krustykrab.domain.handmadeBurger;

import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "HANDMADE_BURGER_ORDER_DETAIL")
public class HandmadeBurgerOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hbOrderInfoId")
    private Long hbOrderInfoId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "vegetable1")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient vegetable1;

    @Column(name = "vegetable2")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient vegetable2;

    @Column(name = "vegetable3")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient vegetable3;

    @Column(name = "patty1")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient patty1;

    @Column(name = "patty2")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient patty2;

    @Column(name = "topping1")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient topping1;

    @Column(name = "topping2")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient topping2;

    @Column(name = "topping3")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient topping3;

    @Column(name = "source1")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient source1;

    @Column(name = "source2")
    @Enumerated(value = EnumType.STRING)
    private BurgerIngredient source2;


}
