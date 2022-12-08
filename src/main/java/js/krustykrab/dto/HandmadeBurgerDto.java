package js.krustykrab.dto;

import js.krustykrab.domain.handmadeBurger.BurgerIngredient;
import js.krustykrab.domain.handmadeBurger.HandmadeBurgerOrderDetail;
import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static js.krustykrab.domain.handmadeBurger.BurgerIngredient.NONE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HandmadeBurgerDto {

    private BurgerIngredient vegetable1;

    private BurgerIngredient vegetable2;

    private BurgerIngredient vegetable3;

    private BurgerIngredient patty1;

    private BurgerIngredient patty2;

    private BurgerIngredient topping1;

    private BurgerIngredient topping2;

    private BurgerIngredient topping3;

    private BurgerIngredient source1;

    private BurgerIngredient source2;


    public HandmadeBurgerOrderDetail toEntity(User user, Order order) {
        return HandmadeBurgerOrderDetail.builder()
                .user(user)
                .order(order)
                .vegetable1(vegetable1)
                .vegetable2(vegetable2)
                .vegetable3(vegetable3)
                .patty1(patty1)
                .patty2(patty2)
                .topping1(topping1)
                .topping2(topping2)
                .topping3(topping3)
                .source1(source1)
                .source2(source2)
                .build();
    }

    public List<BurgerIngredient> getBurgerIngredients() {
        List<BurgerIngredient> ingredients = getPresentIngredient();

        return ingredients;
    }

    private List<BurgerIngredient> getPresentIngredient() {
        List<BurgerIngredient> ingredients = new ArrayList<>();
        ingredients.add(vegetable1);
        ingredients.add(vegetable2);
        ingredients.add(vegetable3);
        ingredients.add(patty1);
        ingredients.add(patty2);
        ingredients.add(topping1);
        ingredients.add(topping2);
        ingredients.add(topping3);
        ingredients.add(source1);
        ingredients.add(source2);

        return removeNoneIngredient(ingredients);
    }

    private List<BurgerIngredient> removeNoneIngredient(List<BurgerIngredient> ingredients) {
        return ingredients.stream()
                .filter(ingredient -> ingredient != NONE)
                .collect(Collectors.toList());
    }

}
