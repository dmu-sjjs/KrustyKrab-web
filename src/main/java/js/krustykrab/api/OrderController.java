package js.krustykrab.api;

import js.krustykrab.domain.cart.Cart;
import js.krustykrab.domain.cart.CartItem;
import js.krustykrab.domain.order.Order;
import js.krustykrab.dto.MenuDto;
import js.krustykrab.dto.StoreDto;
import js.krustykrab.dto.UserDto;
import js.krustykrab.dto.order.OrderDto;
import js.krustykrab.service.MenuService;
import js.krustykrab.service.OrderDetailService;
import js.krustykrab.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final MenuService menuService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;

    @GetMapping("/{storeId}")
    public String toOrderPage(@PathVariable Long storeId, HttpSession session, Model model) {
        UserDto userDto = (UserDto) session.getAttribute("user");

        if (userDto != null) {
            session.setAttribute("cart", new Cart());
            model.addAttribute("storeId", storeId);
            return "/order/orderPage";
        }

        return "redirect:/user/login";
    }

    @PostMapping("/{storeId}/addItem")
    public String addItem(Long menuId, String menuName, int count, HttpSession session) {

        Cart cart = (Cart) session.getAttribute("cart");
        MenuDto menuDto = menuService.findMenu(menuId);
        CartItem cartItem = new CartItem(menuId, menuName, menuDto.getMenuType(), count, menuDto.getPrice());

        cart.addItem(cartItem);
        session.setAttribute("cart", cart);

        return "order/successAddItem";

    }

    @GetMapping("checkMenu")
    public String checkMenu() {

        return "order/checkMenu";
    }

    @PostMapping
    public String order(StoreDto storeDto, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        UserDto user = (UserDto) session.getAttribute("user");
        OrderDto orderDto = new OrderDto(user.getUserId(), storeDto.getStoreId(), user.getAddress(), user.getDetailAddress(), getNowTime(), false);

        session.removeAttribute("cart");
        Order order = orderService.saveOrder(orderDto, storeDto.getStoreId());
        orderDetailService.saveOrderDetail(order, cart);

        return "redirect:/order/successOrder";

    }

    private String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        return sdf.format(c1.getTime());
    }

    @GetMapping("/select/{storeId}")
    public String toMenuSelectPage(@PathVariable Long storeId, Model model) {
        model.addAttribute("menus", menuService.findAllMenu());
        model.addAttribute("storeId", storeId);
        return "/order/menuSelectPage";
    }
}
