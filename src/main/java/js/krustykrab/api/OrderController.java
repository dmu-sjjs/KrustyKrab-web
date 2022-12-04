package js.krustykrab.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/{storeId}")
    public String toOrderPage(@PathVariable Long storeId, Model model) {
        model.addAttribute("storeId", storeId);
        return "/order/orderPage";
    }

    @GetMapping("/select")
    public String toMenuSelectPage() {
        return "/order/menuSelectPage";
    }
}
