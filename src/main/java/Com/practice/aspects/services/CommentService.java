package Com.practice.aspects.services;

import Com.practice.aspects.Comment;
import Com.practice.aspects.ToLog;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final Logger logger =
            Logger.getLogger(CommentService.class.getName());
    private Comment comment;

    @ToLog
    public void publishComment(Comment comment) {
        this.comment = comment;
        logger.info("Publishing comment: " + comment.getText());
    }

//    @ToLog
//    public void deleteComment(Comment comment) {
//        logger.info("Deleting comment: " + comment.getText());
//    }
//
//    public void editComment(Comment comment) {
//        logger.info("Editing comment:" + comment.getText());
//    }


}
