package js.krustykrab.domain.cart;


import java.util.List;

public class Cart {
    private final List<CartItem> cart;

    public Cart(List<CartItem> cart) {
        this.cart = cart;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public List<CartItem> addItem(CartItem item) {
        cart.add(item);
        return cart;
    }
}
