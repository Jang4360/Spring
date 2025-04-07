package Com.practice.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class SecurityAspect {
    private Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around(value = "@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Security Aspect");
        Object returnedValue = joinPoint.proceed(); // 애스펙트 실행 체인에 추가 위임한다. 다음 애스펙트 중 하나를 호출하거나 가로챈 메서드를 실행할 수 있다
        logger.info("Security Aspect: " + returnedValue);
        return returnedValue;
    }
}
