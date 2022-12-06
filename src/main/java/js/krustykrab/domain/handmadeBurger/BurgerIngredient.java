package js.krustykrab.domain.handmadeBurger;

import static js.krustykrab.domain.handmadeBurger.IngredientType.*;

public enum BurgerIngredient {
    LETTUCE(VEGETABLE.name()), ONION(VEGETABLE.name()), TOMATO(VEGETABLE.name()), // Vegetable
    COW(PATTY.name()), CHICKEN(PATTY.name()), SHRIMP(PATTY.name()),   // Patty
    PICKLE(TOPPING.name()), GARLIC(TOPPING.name()), EGGFRY(TOPPING.name()), // Topping
    BBQ(SOURCE.name()), CHILI(SOURCE.name()), RANCH(SOURCE.name()),   // Source
    NONE(null); // None


    private String type;

    BurgerIngredient(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
