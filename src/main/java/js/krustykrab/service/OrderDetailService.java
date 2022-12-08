package js.krustykrab.service;

import js.krustykrab.dao.OrderDetailRepository;
import js.krustykrab.domain.cart.Cart;
import js.krustykrab.domain.cart.CartItem;
import js.krustykrab.domain.menu.Menu;
import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.order.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final MenuService menuService;

    public void saveOrderDetail(Order order, Cart cart) {
        List<CartItem> items = cart.getItems();

        for (CartItem item : items) {
            Menu menu = menuService.findMenu(item.getMenuId()).toHasIdEntity();
            OrderDetail orderDetail = new OrderDetail(order, order.getUser(), menu, item.getCount());
            orderDetailRepository.save(orderDetail);
        }
    }
}
