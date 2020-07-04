package com.database.demo.demo.config.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CommonJoinPointAspectConfig {

    @Pointcut("execution(* com.database.demo.demo.*.*.*(..))")
    public void beforeMethodCall(){}
    @Pointcut("execution(* com.database.demo.demo.*.*.*(..))")
    public void afterMethodCall(){}
    @Pointcut("@annotation(com.database.demo.demo.config.aspect.TraceTime)")
    public void traceTimeAnnotation(){}
}
