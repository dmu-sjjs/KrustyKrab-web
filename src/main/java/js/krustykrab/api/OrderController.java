package js.krustykrab.api;

import js.krustykrab.domain.cart.Cart;
import js.krustykrab.domain.order.Order;
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
            model.addAttribute("storeId", storeId);
            return "/order/orderPage";
        }

        return "redirect:/user/login";
    }

    @PostMapping("/{storeId}")
    public String order(@PathVariable Long storeId, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        UserDto user = (UserDto)session.getAttribute("user");
        OrderDto orderDto = new OrderDto(user.getUserId(), storeId, user.getAddress(), user.getDetailAddress(), getNowTime(), false);

        session.removeAttribute("cart");
        Order order = orderService.saveOrder(orderDto, storeId);
        orderDetailService.saveOrderDetail(order, cart);

        return "redirect:/order/successOrder";

    }

    private String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        return sdf.format(c1.getTime());
    }

    @GetMapping("/select")
    public String toMenuSelectPage(Model model) {
        model.addAttribute("menus", menuService.findAllMenu());
        return "/order/menuSelectPage";
    }
}
