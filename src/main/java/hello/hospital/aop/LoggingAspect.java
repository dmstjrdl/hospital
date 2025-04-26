package hello.hospital.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* hello.hospital..controller..*(..)) || execution(* hello.hospital..service..*(..)) || execution(* hello.hospital..repository..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String requesterName = SecurityContextHolder.getContext().getAuthentication().getName();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();

        long start = System.currentTimeMillis();

        log.info("[{}][START][{}][{}] {}", requesterName, requestURI, className, methodName);

        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("[{}][END][{}][{}] {} ({}ms)", requesterName, requestURI, className, methodName, end - start);
            return result;
        } catch (Throwable e) {
            log.error("[{}][{}][{}] 예외 발생: {} - {}", requesterName, requestURI, className, methodName, e.getMessage());
            throw e;
        }
    }
}
