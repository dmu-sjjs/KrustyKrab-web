package js.krustykrab.api;

import js.krustykrab.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/{storeId}")
    public String toOrderPage(@PathVariable Long storeId, HttpSession session, Model model) {
        try {
            UserDto userDto = (UserDto) session.getAttribute("user");
            model.addAttribute("storeId", storeId);

            return "/order/orderPage";
        }catch (NullPointerException e) {
            return "redirect:/user/login";
        }
    }

    @GetMapping("/select")
    public String toMenuSelectPage() {
        return "/order/menuSelectPage";
    }
}
