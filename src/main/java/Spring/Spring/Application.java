package Spring.Spring;

import Spring.practice.aspects.Comment;
import Spring.practice.aspects.services.CommentService;
import Spring.practice.aspects.ProjectConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var service = c.getBean(CommentService.class);
		Comment comment = new Comment();
		comment.setText("Demo comment");
		comment.setAuthor("natash");
		service.publishComment(comment);
	}

}
