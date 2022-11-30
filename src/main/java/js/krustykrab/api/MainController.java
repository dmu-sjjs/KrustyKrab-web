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

    @GetMapping("/main/menu/sale")
    public String toSalePage() {
        return "index";
    }

    @GetMapping("/main/menu/new")
    public String toNewMenuPage() {
        return "index";
    }
    @GetMapping("/main/menu/burger")
    public String toBurgerMenuPage() {
        return "index";
    }
    @GetMapping("/main/menu/side")
    public String toSideMenuPage() {
        return "index";
    }
    @GetMapping("/main/menu/drinkAndDesert")
    public String toDrinkAndDesertPage() {
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
