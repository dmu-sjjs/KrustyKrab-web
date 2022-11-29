package js.krustykrab.api;

import js.krustykrab.dto.UserDto;
import js.krustykrab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // 로그인 관련
    @GetMapping("/login")
    public String toLoginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(UserDto userDto, HttpSession session, Model model) {
        userDto = userService.login(userDto);
        if(userDto != null){
            System.out.println(userDto.getUsername()+"님이 로그인하셨습니다.");
            session.setAttribute("user",userDto);
            return "redirect:/";
        }
        System.out.println("로그인 실패!");
        model.addAttribute("isLoginSuccess", false);
        return "redirect:joinFail";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }

    // 회원가입 관련
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

    @GetMapping("/join/idDuplicationCheck")
    public String toIdDuplicationCheckForm() {
        return "duplicationCheck";
    }

    @PostMapping("/join/idDuplicationCheck")
    public String idDuplicationCheck(UserDto userDto, HttpServletRequest rq) {
        boolean isDuplicate = userService.duplicationCheck(userDto.getId());

        rq.setAttribute("isDuplicate", false);
        rq.setAttribute("id", userDto.getId());
        if(isDuplicate){
            rq.setAttribute("isDuplicate", true);
        }

        return "duplicationCheck";
    }

    @GetMapping("/joinFail")
    public String joinFail() {
        return "joinFail";
    }
}
