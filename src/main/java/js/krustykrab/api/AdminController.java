package js.krustykrab.api;

import js.krustykrab.dto.UserDto;
import js.krustykrab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;


    @GetMapping("/main")
    public String toAdminPage(Model model) {
        ArrayList<UserDto> users = userService.findAllUser();
        model.addAttribute("users", users);

        return "adminPage";
    }
}
