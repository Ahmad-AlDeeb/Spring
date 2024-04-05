package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.Expressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before on -->  MyDemoLoggingAspect");
    }

//    @AfterReturning(
//            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.getAllAccounts(..))",
//            returning = "result")
//    public void afterReturningGetAllAccounts(JoinPoint theJoinPoint, List<Account> result) {
//        System.out.println("=====>>> Executing @AfterReturning on --> " + theJoinPoint.getSignature().toShortString());
//        System.out.println("Post-processing for return result.....");
//    }
//
//
//    @AfterThrowing(
//            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.getAllAccounts(..))",
//            throwing = "theExc")
//    public void afterThrowingGetAllAccounts(
//            JoinPoint theJoinPoint, Throwable theExc) {
//        System.out.println("=====>>> Executing @AfterThrowing on --> " + theJoinPoint.getSignature().toShortString());
//        System.out.println("Logging exception.....");
//    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.getAllAccounts(..))")
    public void afterFinallyGetAllAccounts(JoinPoint theJoinPoint) {
        System.out.println("=====>>> Executing @After on --> " + theJoinPoint.getSignature().toShortString());
    }


    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("=====>>> Executing @Around on --> " + proceedingJoinPoint.getSignature().toShortString());

        System.out.println("Doing work BEFORE proceeding.....");
        try {
            proceedingJoinPoint.proceed();
        }
        catch (Exception exc) {
            System.out.println("Logging exception.....");
//             Maybe re-throwing the exception if needed?
//            System.out.println("Re-throwing exception.....");
//            throw exc;
        }
        System.out.println("Doing work AFTER proceeding.....");

        return "Processed result.....";
    }
}

@Aspect
@Component
@Order(2)
class MyCloudLogAsyncAspect {

    @Before("com.luv2code.aopdemo.aspect.Expressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("=====>>> Logging to Cloud in async fashion");
    }


    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.getAllAccounts(..))")
    public void afterFinallyGetAllAccounts(JoinPoint theJoinPoint) {
        System.out.println("=====>>> Executing @After on --> MyCloudLogAsyncAspect");
    }

}


@Aspect
@Component
@Order(3)
class MyApiAnalyticsAspect {

    @Before("com.luv2code.aopdemo.aspect.Expressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("=====>>> Performing API analytics");
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.getAllAccounts(..))")
    public void afterFinallyGetAllAccounts(JoinPoint theJoinPoint) {
        System.out.println("=====>>> Executing @After on --> MyApiAnalyticsAspect");
    }

}








