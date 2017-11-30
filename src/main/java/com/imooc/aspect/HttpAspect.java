package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author 向亚林
 * 2017/11/30
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void aspect(){
    }

    /**
     * 前置切面
     * @param joinPoint AspectJ中的切入点匹配的执行点称作连接的（Join Point）通过JoinPoint可以访问连接点的细节
     */
    @Before("aspect()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("1111111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());


    }

    @After("aspect()")
    public void doAfter(){
        logger.info("222222");
    }

    @AfterReturning(pointcut = "aspect()", returning = "object")
    public void doAfterReturning(Object object){
        logger.info("response={}", object.toString());
    }
}
