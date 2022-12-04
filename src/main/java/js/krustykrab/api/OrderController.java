package js.krustykrab.api;

import js.krustykrab.domain.cart.Cart;
import js.krustykrab.dto.UserDto;
import js.krustykrab.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final MenuService menuService;

    @GetMapping("/{storeId}")
    public String toOrderPage(@PathVariable Long storeId, HttpSession session, Model model) {
        UserDto userDto = (UserDto) session.getAttribute("user");

        if(userDto != null) {
            model.addAttribute("storeId", storeId);
            return "/order/orderPage";
        }

        return "redirect:/user/login";
    }

//    @PostMapping("/{storeId}")
//    public String order(@PathVariable Long storeId, HttpSession session) {
//        Cart cart = (Cart) session.getAttribute("cart");
//        session.removeAttribute("cart");
//
//
//    }

    @GetMapping("/select")
    public String toMenuSelectPage(Model model) {
        model.addAttribute("menus", menuService.findAllMenu());
        return "/order/menuSelectPage";
    }
}
