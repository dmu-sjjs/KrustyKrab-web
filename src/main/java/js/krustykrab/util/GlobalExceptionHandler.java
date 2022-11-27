package js.krustykrab.util;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 컨트롤러에서 발생하는 모든 예외를 처리 하도록 @ControllerAdvice 선언함
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public String hanlderException(Exception exception, Model model) {
//        model.addAttribute("exception", exception);
//        return "/errors/globalError";
//    }
//}
