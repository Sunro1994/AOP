package com.sunro.AOP_Practice.global.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    @Before("execution(* com.sunro.AOP_Practice.domain.member.service.UserService.*(..))")
    public void logBefore(){
        log.info("\"A method in UserSErvice is executed\"");
    }


    @Around("execution(* com.sunro.AOP_Practice.domain.member.service.UserService.*(..)))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        log.info("{} excuted in {} ms", joinPoint.getSignature(), executionTime);
        return joinPoint.proceed();
    }

    @AfterReturning(pointcut = "execution(* com.sunro.AOP_Practice.domain.member.service.UserService.*.*(..))",returning = "result")
    public void longAfterReturning(Object result) {
        log.info("method in UserSErvice has returned : {} ", result);
    }


    @AfterThrowing(pointcut = "execution(* com.sunro.AOP_Practice.domain.member.service.UserService.*(..))",throwing = "e")
    public void logAfterThrowing(Throwable e) {
        log.info("method in UserSErvice has thrown : {} ", e.getMessage());
    }

    @After("execution(* com.sunro.AOP_Practice.domain.member.service.UserService.*(..))")
    public void logAfter(){
        log.info("method has fininshed execution");
    }


}
