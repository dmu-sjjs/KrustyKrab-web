package js.krustykrab.domain.cart;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> cart;

    public Cart() {
        cart = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return cart;
    }

    public List<CartItem> addItem(CartItem item) {
        cart.add(item);
        return cart;
    }

    public List<CartItem> removeItem(Long menuId) {
        cart.removeIf(item -> item.getMenuId().equals(menuId));

        return cart;
    }
}
