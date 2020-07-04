package com.database.demo.demo.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspectLogging {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(value = "com.database.demo.demo.config.aspect.CommonJoinPointAspectConfig.afterMethodCall()",returning = "result")
    public void afterCallingMethod(JoinPoint joinPoint,Object result){
        logger.info("===================return result {} ============================================",result);
    }
}
