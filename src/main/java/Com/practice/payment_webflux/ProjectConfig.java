package Com.practice.payment_webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

//@Configuration
public class ProjectConfig {
    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .build();
    }
}
