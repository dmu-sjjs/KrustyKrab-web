package js.krustykrab.dto;

import js.krustykrab.domain.handmadeBurger.BurgerIngredient;
import js.krustykrab.domain.handmadeBurger.HandmadeBurgerOrderDetail;
import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HandmadeBurgerDto {

    private String vegetable1;

    private String vegetable2;

    private String vegetable3;

    private String patty1;

    private String patty2;

    private String topping1;

    private String topping2;

    private String topping3;

    private String source1;

    private String source2;


    public HandmadeBurgerOrderDetail toEntity(User user, Order order) {
        return HandmadeBurgerOrderDetail.builder()
                .user(user)
                .order(order)
                .vegetable1(BurgerIngredient.valueOf(vegetable1))
                .vegetable2(BurgerIngredient.valueOf(vegetable2))
                .vegetable3(BurgerIngredient.valueOf(vegetable3))
                .patty1(BurgerIngredient.valueOf(patty1))
                .patty2(BurgerIngredient.valueOf(patty2))
                .topping1(BurgerIngredient.valueOf(topping1))
                .topping2(BurgerIngredient.valueOf(topping2))
                .topping3(BurgerIngredient.valueOf(topping3))
                .source1(BurgerIngredient.valueOf(source1))
                .source2(BurgerIngredient.valueOf(source2))
                .build();
    }
}
