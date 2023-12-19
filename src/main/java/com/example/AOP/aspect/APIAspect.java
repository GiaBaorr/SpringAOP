package com.example.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class APIAspect {

    @Before("com.example.AOP.aspect.AopExpression.forAllButGetterSetter()")
    public void APIAnalystic(){
        System.out.println();
        System.out.println("API =========");
    }
}
