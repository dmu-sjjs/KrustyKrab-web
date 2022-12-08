package js.krustykrab.domain.handmadeBurger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static js.krustykrab.domain.handmadeBurger.IngredientType.*;

public enum BurgerIngredient {
    LETTUCE(VEGETABLE, 700, "양상추"), ONION(VEGETABLE, 500, "양파"), TOMATO(VEGETABLE, 600, "토마토"), // Vegetable
    BEEF(PATTY, 2000, "소고기 패티"), CHICKEN(PATTY, 2300, "치킨 패티"), HAM(PATTY, 1800, "햄 패티"),   // Patty
    PICKLE(TOPPING, 300, "피클"), GARLIC(TOPPING, 200, "구운 마늘"), EGGFRY(TOPPING, 800, "계란후라이"), // Topping
    BBQ(SOURCE, 300, "BBQ 소스"), CHILI(SOURCE, 300, "칠리 소스"), RANCH(SOURCE, 300, "렌치 소스"),   // Source
    NONE(null, 0, ""); // None

    private IngredientType type;
    private int price;
    private String name;

    BurgerIngredient(IngredientType type, int price, String name) {
        this.price = price;
        this.type = type;
        this.name = name;
    }

    public IngredientType getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
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
