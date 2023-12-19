package com.example.AOP.aspect;

import com.example.AOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class LoggingAspect {

    @Before("com.example.AOP.aspect.AopExpression.forAllButGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJointPoint) {
        System.out.println();
        System.out.println("Function =========");

        MethodSignature methodSignature = (MethodSignature) theJointPoint.getSignature();
        System.out.println("Method : " + methodSignature);

        Object[] args = theJointPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("Args : " + args[i]);
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.example.AOP.dao.AccountDAO.findAccounts(..))",
            returning = "results"
    )
    public void afterReturningFindAccountAdvice(JoinPoint theJointPoint, List<Account> results) {

        String method = theJointPoint.getSignature().toShortString();
        System.out.println("=>>>>>> Executing @AfterReturing on method " + method);

        System.out.println("=>>>>>> result is : " + results);

        convertAccountNameToUpperCase(results);

        System.out.println("=>>>>>> result after modified : " + results);


    }

    private void convertAccountNameToUpperCase(List<Account> results) {
        results.forEach(account -> {
            account.setName(account.getName().toUpperCase());
        });
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.AOP.dao.AccountDAO.*(..))",
            throwing = "thrExc"
    )
    public void afterThrowingAdvice(JoinPoint theJointPoint, Throwable thrExc) {

        String method = theJointPoint.getSignature().toShortString();
        System.out.println("Method : " + method);

        System.out.println("The exception is : " + thrExc);
    }

    @After("execution(* com.example.AOP.dao.AccountDAO.*(..))")
    public void afterFinallyAdvice(JoinPoint theJointPoint) {
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("Method (finally) : " + method);

    }


    @Around("execution(* com.example.AOP.service.*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        System.out.println("Begin AROUND *****");
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("Method : " + method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("@Around : got a problem " + ex);
            throw ex;
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;

        System.out.println("Duration : " + duration);
        System.out.println("End Around ******");
        return result;
    }


}










