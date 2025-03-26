package Spring.practice.loginRequestScope;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component // 스프링에 이 클래스가 빈임을 지정
@RequestScope // 빈을 요청 스코프로 지정
@Getter
@Setter
public class LoginProcessor {
    private String username;
    private String password;

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();

        if ("name".equals(username) && "password".equals(username)) {
            return true;
        } else {
            return false;
        }
    }
}
