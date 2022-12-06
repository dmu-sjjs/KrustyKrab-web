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
import java.util.List;

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
            model.addAttribute("menus", menuService.findAllMenu());
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

    @PostMapping("/{storeId}/removeItem")
    public String removeItem(@PathVariable Long storeId, Long menuId, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeItem(menuId);

        session.setAttribute("cart", cart);

        return "redirect:/order/"+storeId.toString()+"/checkMenu";
    }

    @GetMapping("/{storeId}/checkMenu")
    public String checkMenu(@PathVariable Long storeId, Model model) {
        model.addAttribute("storeId", storeId);
        return "order/checkMenu";
    }

    @PostMapping
    public String order(Long storeId, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        UserDto user = (UserDto) session.getAttribute("user");
        OrderDto orderDto = new OrderDto(user.getUserId(), storeId, user.getAddress(), user.getDetailAddress(), getNowTime(), false);

        Order order = orderService.saveOrder(orderDto, storeId);
        orderDetailService.saveOrderDetail(order, cart);

        return "redirect:/order/orderSuccess";
    }

    @GetMapping("/orderSuccess")
    public String toOrderSuccessPage(HttpSession session, Model model){
        Cart cart = (Cart) session.getAttribute("cart");
        session.removeAttribute("cart");

        model.addAttribute("cartItems", cart.getItems());
        System.out.println("model에 값 저장");
        return "/order/orderSuccess";
    }

    private String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-mm:ss");
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
