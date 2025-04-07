package Com.practice.loginSessionScope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginProcessor loginProcessor;

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean isLogin = loginProcessor.login();

        if (isLogin) {
            return "redirect:/main"; // 성공하면 메인페이지로 리다이렉션
        }

        // 실패하면 로그인페이지로
        model.addAttribute("message", "login failed");
        return "login.html";
    }
}
