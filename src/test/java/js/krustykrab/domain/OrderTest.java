package js.krustykrab.domain;

import js.krustykrab.domain.cart.Cart;
import js.krustykrab.domain.cart.CartItem;
import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.Authority;
import js.krustykrab.domain.user.User;
import js.krustykrab.dto.order.OrderDetailDto;
import js.krustykrab.dto.order.OrderDto;
import js.krustykrab.service.OrderDetailService;
import js.krustykrab.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@SpringBootTest
class OrderTest {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;

    @Test
    void toDtoTest() {
        User user = new User(1L, "ADMIN", "ADMIN", "ADMIN", "ADMIN", "ADMIN", "ADMIN", Authority.USER);
        Store store = new Store(1L,"STORENAME","1.123","1.123","010-10101");
        Order order = new Order(1L, user, store, "ADDRESS", "D_ADDRESS", "20221231", false);

        Cart cart = new Cart();
        cart.addItem(new CartItem(1L, 10));
        cart.addItem(new CartItem(2L, 12));


        OrderDto orderDto = order.toDto();

        Order order1 = orderService.saveOrder(orderDto, store.getStoreId());
        System.out.println("store.getStoreId() = " + store.getStoreId());
        orderDetailService.saveOrderDetail(order1, cart);

    }
    /*
    public void saveOrderDetail(Order order, Cart cart) {
        List<CartItem> items = cart.getItems();

        for (CartItem item : items) {
            Menu menu = menuService.findMenu(item.getMenuId()).toHasIdEntity();
            orderDetailRepository.save(new OrderDetail(order, order.getUser(), menu, item.getCount()));
        }
    }
     */
}