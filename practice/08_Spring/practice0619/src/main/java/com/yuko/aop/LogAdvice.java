package com.yuko.aop;

import com.yuko.dto.MessageDTO;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class LogAdvice {
    @Before("execution(* com.yuko.service.MessageService*.*(..))")
    public void logBefore() {
        // 메시지 내용 출력 해야함
        log.info("✅ [Before] 전달된 파라미터: ");
    }

    @Around("execution(* com.yuko.service.MessageService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        log.info("🕛 [Around] sendMessage 실행 시간: " + (end - start));

        return result;
    }
}
