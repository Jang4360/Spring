package Spring.practice.aspects;

import Spring.practice.aspects.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "Spring.practice.aspects")
@EnableAspectJAutoProxy
public class ProjectConfig {
    @Bean
    public CommentService commentService() {
        return new CommentService();
    }

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
