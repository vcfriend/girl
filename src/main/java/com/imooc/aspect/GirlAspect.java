package com.imooc.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 向亚林
 * 2017/11/30
 */
@Aspect
@Component
public class GirlAspect {
    @Before("execution(public * com.imooc.controller.GirlController.*(..))")
    public void log(){
        System.out.println("11111111");
    }

    @After("execution(public * com.imooc.controller.GirlController.*(..))")
    public void doAfter(){
        System.out.println("2222222");
    }
}
