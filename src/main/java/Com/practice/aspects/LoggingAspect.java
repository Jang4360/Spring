package Com.practice.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect // 스프링 컨텍스트에 빈으로 추가되지 않는다 (Configuration 클래스에서 직접 빈 등록해야됨)
@Order(2)
public class LoggingAspect { // aspect 를 정의하는 클래스
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)") // 스프링이 어떤 메서드 호출을 가로채야 하는지 지정 -> AspectJ 포인트컷 언어
    // 모든 타입 가능, services 패키지에 속한 것, 모든 클래스도 가능, 모든 메서드 가능, 모든 매개변수 가능

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable { // ProceedingJoinPoint: 실제 메서드에 추가 위임해야하는 시점 알려준다
        logger.info("Logging Aspect");
        Object returnedValue = joinPoint.proceed();
        logger.info("Logging Aspect: " + returnedValue);
        return returnedValue;

//        String methodName = joinPoint.getSignature().getName();
//        Object[] arguments = joinPoint.getArgs();
//
//        logger.info("Method "+methodName+" with parameters " + Arrays.asList(arguments)+" will execute"); // 가로챌 메서드 실행전 메시지 출력
//
//        Comment comment = new Comment();
//        comment.setText("NEW TEXT!");
//        Object[] newArguments = {comment};
//        Object returnedByMethod = joinPoint.proceed(newArguments); // 가로챌 메서드 호출
//        logger.info("Method executed and returned " + returnedByMethod);
//        return "FAILED"; // 가로챈 메서드 반환
    }
}
