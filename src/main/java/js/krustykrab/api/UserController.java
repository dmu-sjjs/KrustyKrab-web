package js.krustykrab.api;

import js.krustykrab.dto.UserDto;
import js.krustykrab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String login(UserDto userDto, String saveIdPw, HttpSession session, Model model) {
        userDto = userService.login(userDto);
        if (userDto != null) {
            session.setAttribute("user", userDto);
            checkSaveIdPw(userDto, saveIdPw, session);
            return "redirect:/";
        }
        model.addAttribute("isLoginSuccess", false);
        return "redirect:loginFail";
    }

    private void checkSaveIdPw(UserDto userDto, String saveIdPw, HttpSession session) {
        if (saveIdPw != null) {
            session.setAttribute("id", userDto.getId());
            session.setAttribute("pw", userDto.getPw());
            session.setAttribute("saveIdPw", "checked");
        } else {
            session.setAttribute("id", "");
            session.setAttribute("pw", "");
            session.setAttribute("saveIdPw", "");
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    // 회원가입 관련
    @GetMapping("/join")
    public String toJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@RequestParam("idDuplicationCheck") String dupCheck, UserDto userDto, HttpSession session) {
        userDto = userService.join(userDto);
        if (userDto != null && dupCheck.equals("1")) {
            session.setAttribute("joinedUser", userDto);
            return "redirect:/";
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
        if (isDuplicate) {
            rq.setAttribute("isDuplicate", true);
        }

        return "duplicationCheck";
    }

    @GetMapping("/joinFail")
    public String joinFail() {
        return "joinFail";
    }

    @GetMapping("/loginFail")
    public String loginFail() {
        return "loginFail";
    }

//    private boolean authorityCheck
}
