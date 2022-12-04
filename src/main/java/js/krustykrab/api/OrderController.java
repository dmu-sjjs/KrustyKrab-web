package js.krustykrab.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public String toOrderPage() {
        return "/order/orderPage";
    }

    @GetMapping("/select")
    public String toMenuSelectPage() {
        return "/order/menuSelectPage";
    }
}
