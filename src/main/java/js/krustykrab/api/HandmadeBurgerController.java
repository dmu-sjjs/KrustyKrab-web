package js.krustykrab.api;

import js.krustykrab.domain.order.Order;
import js.krustykrab.dto.HandmadeBurgerDto;
import js.krustykrab.dto.UserDto;
import js.krustykrab.dto.order.OrderDto;
import js.krustykrab.service.HandmadeBurgerDetailService;
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

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/handmade")
public class HandmadeBurgerController {
    private final OrderService orderService;
    private final HandmadeBurgerDetailService handmadeService;

    @GetMapping("/{storeId}")
    public String toHandmadePage(@PathVariable String storeId, Model model) {
        model.addAttribute("storeId", storeId);

        return "/order/handmadePage";
    }

    @PostMapping("/{storeId}")
    public String orderHandmadeBurger(@PathVariable Long storeId, HandmadeBurgerDto handmadeBurgerDto, HttpSession session) {
        UserDto user = (UserDto) session.getAttribute("user");
        OrderDto orderDto = new OrderDto(user.getUserId(), storeId, user.getAddress(), user.getDetailAddress(), getNowTime(), false);

        Order order = orderService.saveOrder(orderDto, storeId);
        handmadeService.saveHandmadeOrderDetail(handmadeBurgerDto, order);
        session.setAttribute("handmadeIngredient", handmadeBurgerDto);

        return "redirect:/order/handmade/orderSuccess";
    }

    @GetMapping("orderSuccess")
    public String orderSuccess(HttpSession session, Model model) {
        HandmadeBurgerDto handmadeIngredient = (HandmadeBurgerDto) session.getAttribute("handmadeIngredient");
        session.removeAttribute("handmadeIngredient");
        model.addAttribute("handmadeIngredient", handmadeIngredient);

        return "/order/handmadeOrderSuccess";
    }

    private String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-mm:ss");
        Calendar c1 = Calendar.getInstance();
        return sdf.format(c1.getTime());
    }
}
