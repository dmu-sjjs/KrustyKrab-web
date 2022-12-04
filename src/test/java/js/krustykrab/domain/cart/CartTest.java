package js.krustykrab.domain.cart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void getCart() {
    }

    @Test
    void addItem() {
        Cart cart = new Cart();
        CartItem item = new CartItem(1L,1000);
        cart.addItem(item);
        List<CartItem> cart1 = cart.getItems();
        List<CartItem> cartList = cart.getItems();

        assertThat(cartList.get(0)).isEqualTo(item);
        assertThat(cartList.get(0).getMenuId()).isEqualTo(1L);
        assertThat(cartList.get(0).getCount()).isEqualTo(1000);
    }

    @Test
    void removeItem() {
        Cart cart = new Cart();
        CartItem item = new CartItem(1L,1000);
        cart.addItem(item);

        List<CartItem> cartItems = cart.removeItem(1L);
        assertThat(cartItems.isEmpty()).isTrue();
    }
}