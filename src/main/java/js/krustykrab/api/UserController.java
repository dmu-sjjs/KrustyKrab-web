package js.krustykrab.api;

import js.krustykrab.domain.User;
import js.krustykrab.dto.UserDto;
import js.krustykrab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/login")
    public String toLoginForm() {
        return "loginForm";
    }

//    @PostMapping("/login")
//    public String login() {
//        return "loginForm";
//    }

    @GetMapping("/join")
    public String toJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String join(UserDto userDto, Model model) throws Exception {
        Optional<User> joinUser = userService.join(userDto);
        if (joinUser.isEmpty()) {
            throw new Exception();
        }
        model.addAttribute("userDto", joinUser.get());
        return "joinSuccess";
    }

}
