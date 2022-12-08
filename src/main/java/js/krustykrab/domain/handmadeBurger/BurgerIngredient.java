package js.krustykrab.domain.handmadeBurger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static js.krustykrab.domain.handmadeBurger.IngredientType.*;

public enum BurgerIngredient {
    LETTUCE(VEGETABLE.name(), 700), ONION(VEGETABLE.name(), 500), TOMATO(VEGETABLE.name(), 600), // Vegetable
    BEEF(PATTY.name(), 2000), CHICKEN(PATTY.name(), 2300), HAM(PATTY.name(), 1800),   // Patty
    PICKLE(TOPPING.name(), 300), GARLIC(TOPPING.name(), 200), EGGFRY(TOPPING.name(), 800), // Topping
    BBQ(SOURCE.name(), 300), CHILI(SOURCE.name(), 300), RANCH(SOURCE.name(), 300),   // Source
    NONE(null, 0); // None


    private String type;
    private int price;

    BurgerIngredient(String type, int price) {
        this.price = price;
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public Integer getPrice() {
        return price;
    }

    public static List<BurgerIngredient> getAllIngredients() {
        return Arrays.stream(values()).collect(Collectors.toList());
    }

    public static List<BurgerIngredient> getVegetables() {
        return Arrays.stream(values())
                .filter(ingredient -> ingredient.type.equals(VEGETABLE))
                .collect(Collectors.toList());
    }

    public static List<BurgerIngredient> getPattys() {
        return Arrays.stream(values())
                .filter(ingredient -> ingredient.type.equals(PATTY))
                .collect(Collectors.toList());
    }

    public static List<BurgerIngredient> getToppings() {
        return Arrays.stream(values())
                .filter(ingredient -> ingredient.type.equals(TOPPING))
                .collect(Collectors.toList());
    }

    public static List<BurgerIngredient> getSources() {
        return Arrays.stream(values())
                .filter(ingredient -> ingredient.type.equals(SOURCE))
                .collect(Collectors.toList());
    }
}
