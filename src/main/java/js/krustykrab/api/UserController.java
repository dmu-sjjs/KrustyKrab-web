package js.krustykrab.api;

import js.krustykrab.dto.user.UserDto;
import js.krustykrab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/login")
    public String toLoginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(UserDto userDto, HttpSession session, Model model) {
        userDto = userService.login(userDto);
        if(userDto != null){
            session.setAttribute("user",userDto);
            return "redirect:/";
        }
        model.addAttribute("isLoginSuccess", false);
        return "redirect:login";
    }

    @GetMapping("/join")
    public String toJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String join(UserDto userDto, HttpSession session) {
        userDto = userService.join(userDto);
        if (userDto != null) {
            session.setAttribute("joinedUser", userDto);
            return "redirect:joinSuccess";
        }
        return "redirect:joinFail";
    }

    @GetMapping("/joinSuccess")
    public String joinSuccess() {
        return "joinSuccess";
    }

    @GetMapping("/joinFail")
    public String joinFail() {
        return "joinFail";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }

}
