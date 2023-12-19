package com.example.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-200)
public class CloudAspect {

    @Before("com.example.AOP.aspect.AopExpression.forAllButGetterSetter()")
    public void CloudAspect(){
        System.out.println();
        System.out.println("Cloud =========");
    }
}
