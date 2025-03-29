package Spring.practice.loginSessionScope;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@RequiredArgsConstructor
@Getter
@Setter
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    public boolean login(){
        loginCountService.increment();

        String username = this.getUsername();
        String password = this.getPassword();
        boolean loginResult = false;
        if ("name".equals(username) && "password".equals(password)){
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }
        return loginResult;
    }
}
