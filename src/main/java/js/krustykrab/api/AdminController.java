package js.krustykrab.api;

import js.krustykrab.dto.UserDto;
import js.krustykrab.service.AdminService;
import js.krustykrab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final AdminService adminService;


    @GetMapping("/main")
    public String toAdminPage(Model model, HttpSession session) {
        try {
            UserDto user = (UserDto) session.getAttribute("user");
            adminService.checkAuthority(user);
        } catch (Exception e) {
            return "authenticateFail";
        }
        ArrayList<UserDto> users = userService.findAllUser();
        model.addAttribute("users", users);

        return "adminPage";
    }

    @GetMapping("authenticateFail")
    public String authenticateFail() {
        return "redirect:authenticateFail";
    }
}
