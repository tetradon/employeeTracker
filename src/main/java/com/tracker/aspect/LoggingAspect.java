package com.tracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger =  Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.tracker.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.tracker.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.tracker.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forApp(){}

    @Before("forApp()")
    private void before(JoinPoint joinPoint){
        logger.info(" >>> @Before " + joinPoint.getSignature().toShortString());

        Object args[] = joinPoint.getArgs();
        for(Object arg: args){
            logger.info(" >>> argument is: " + arg);
        }
    }

    @AfterReturning(pointcut = "forApp()", returning = "result")
    private void afterReturning(JoinPoint joinPoint, Object result){
        logger.info(" >>> @AfterReturning " + joinPoint.getSignature().toShortString());
        logger.info(" >>> returned: " + result);
    }
}
