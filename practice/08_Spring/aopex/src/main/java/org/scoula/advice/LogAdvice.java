package org.scoula.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j2
@Component
public class LogAdvice {
    @Before("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public void logBefore() {
        log.info("=============================================");
    }

    @Before("execution(* org.scoula.sample.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
    public void logBeforeWithParam(String str1, String str2) {
        log.info("str1:" + str1);
        log.info("str2:" + str2);
    }

    @AfterThrowing(pointcut = "execution(* org.scoula.sample.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        log.info("Exception...!!!");
        log.info("exception: " + exception);
    }

    // Around: 함수 전후를 감싸서 유연하게 처리해주는 Advice
    // ProceedingJoinPoint: 대상 메소드 호출을 제어할 수 있는 객체
    @Around("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        log.info("Target: " + pjp.getTarget()); // 대상 객체
        log.info("Param: " + Arrays.toString(pjp.getArgs())); // 전달된 인자들

        Object result = null;
        try {
            result = pjp.proceed(); // 실제 메서드 실행
        } catch (Throwable e) {
            e.printStackTrace(); // 예외 발생 시 출력
        }

        long end = System.currentTimeMillis();

        log.info("TIME: " + (end - start));

        return result;
    }
}
