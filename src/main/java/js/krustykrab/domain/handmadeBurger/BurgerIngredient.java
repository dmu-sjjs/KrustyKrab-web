package js.krustykrab.domain.handmadeBurger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static js.krustykrab.domain.handmadeBurger.IngredientType.*;

public enum BurgerIngredient {
    LETTUCE(VEGETABLE, 700), ONION(VEGETABLE, 500), TOMATO(VEGETABLE, 600), // Vegetable
    BEEF(PATTY, 2000), CHICKEN(PATTY, 2300), HAM(PATTY, 1800),   // Patty
    PICKLE(TOPPING, 300), GARLIC(TOPPING, 200), EGGFRY(TOPPING, 800), // Topping
    BBQ(SOURCE, 300), CHILI(SOURCE, 300), RANCH(SOURCE, 300),   // Source
    NONE(null, 0); // None

    private IngredientType type;
    private int price;

    BurgerIngredient(IngredientType type, int price) {
        this.price = price;
        this.type = type;
    }

    public IngredientType getType() {
        return type;
    }
    public Integer getPrice() {
        return price;
    }

    public static List<BurgerIngredient> getAllIngredients() {
        return new ArrayList<>(Arrays.asList(values()));
    }



    public static List<BurgerIngredient> getVegetables() {
        List<BurgerIngredient> vegetables = getAllIngredients().stream()
                .filter(ingredient -> ingredient.type == VEGETABLE)
                .collect(Collectors.toList());

        return vegetables;
    }

    public static List<BurgerIngredient> getPattys() {
        List<BurgerIngredient> pattys = getAllIngredients().stream()
                .filter(ingredient -> ingredient.type == PATTY)
                .collect(Collectors.toList());

        return pattys;
    }

    public static List<BurgerIngredient> getToppings() {
        List<BurgerIngredient> toppings = getAllIngredients().stream()
                .filter(ingredient -> ingredient.type == TOPPING)
                .collect(Collectors.toList());

        return toppings;
    }

    public static List<BurgerIngredient> getSources() {
        List<BurgerIngredient> sources = getAllIngredients().stream()
                .filter(ingredient -> ingredient.type == SOURCE)
                .collect(Collectors.toList());

        return sources;
    }
}
