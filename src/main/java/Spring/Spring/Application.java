package Spring.Spring;

import Spring.practice.aspects.Comment;
import Spring.practice.aspects.Main;
import Spring.practice.aspects.services.CommentService;
import Spring.practice.aspects.ProjectConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

//@SpringBootApplication
public class Application {
	private static Logger logger = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var service = c.getBean(CommentService.class);
		Comment comment = new Comment();
		comment.setText("Demo comment");
		comment.setAuthor("natash");

		String value = service.publishComment(comment);
		logger.info(value);
	}

}
