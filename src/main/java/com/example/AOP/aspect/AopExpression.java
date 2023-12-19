package com.example.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {

    @Pointcut("execution(* com.example.AOP.dao.*.*(..))")
    public void addFunctionPointCut(){}

    @Pointcut("execution(* com.example.AOP.dao.*.set*(..))")
    public void addSetterPointCut(){}

    @Pointcut("execution(* com.example.AOP.dao.*.get*(..))")
    public void addGetterPointCut(){}

    @Pointcut("addFunctionPointCut() && !addSetterPointCut() && !addGetterPointCut()")
    public void forAllButGetterSetter(){}
}
