package js.krustykrab.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/main/event")
    public String toEventPage() {
        return "index";
    }
    @GetMapping("/main/brand/story")
    public String toBrandStoryPage() {
        return "index";
    }
    @GetMapping("/main/brand/burger")
    public String toBrandBurgerPage() {
        return "index";
    }

}
