package hello.hospital;

import hello.hospital.user.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {

    @ModelAttribute
    public void loginCheckAttribute(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("userId", user.getId());
            model.addAttribute("name", user.getName());
        }
    }
}
