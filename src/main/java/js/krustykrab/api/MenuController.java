package js.krustykrab.api;

import com.opencsv.exceptions.CsvValidationException;
import js.krustykrab.csv.MenuCsvParser;
import js.krustykrab.dto.MenuDto;
import js.krustykrab.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/{menuId}")
    public String showMenu(@PathVariable Long menuId, Model model, HttpServletRequest rq) throws UnsupportedEncodingException {
        MenuDto menu = menuService.findMenu(menuId);
        rq.setCharacterEncoding("utf-8");
        model.addAttribute("menu", menu);

        return "showMenu"; // index : 임시값
    }

    @GetMapping("/add/default")
    public String defaultMenuSetting() throws CsvValidationException, IOException {
        menuService.addDefaultMenu();

        return "redirect:index"; // index : 임시값
    }

    @PostMapping("/add")
    public String addMenu(MenuDto menuDto) {
        menuService.save(menuDto);

        return "redirect:index"; // index : 임시값
    }

    @GetMapping("/all")
    public String showAllMenu(Model model) {
        List<MenuDto> allMenu = menuService.findAllMenu();
        model.addAttribute("menuList", allMenu);

        return "redirect:index"; // index : 임시값
    }
}
