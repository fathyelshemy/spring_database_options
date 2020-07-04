package com.database.demo.demo.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspectLogging {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("com.database.demo.demo.config.aspect.CommonJoinPointAspectConfig.beforeMethodCall()")
    public void beforeLogging(JoinPoint joinPoint){
        logger.info("===============================before call"+joinPoint+"============================================");
    }
}
