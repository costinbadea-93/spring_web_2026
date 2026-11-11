package utils;

import model.BankAccount;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BankAccountAspect {

    //joinpoint -> metadata about the method being intercepted
    //pointcut -> expression that matches joinpoints
    //advice -> before, after, afterthrowing, afterreturning, around

    @Pointcut("execution(* service.BankAccountService.*(..))")
    public void bankAccountPointcut() {
    }

    @Before("bankAccountPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("Before executing method: "
                + methodName + " with arguments: "
                + Arrays.toString(args));
    }

    @After("bankAccountPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("After executing method: "
                + methodName + " with arguments: "
                + Arrays.toString(args));
    }

    @AfterReturning(pointcut = "bankAccountPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("After returning from method: "
                + methodName + " with arguments: "
                + Arrays.toString(args) + " and result: " + result);
    }

    @AfterThrowing(pointcut = "bankAccountPointcut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("After throwing exception from method: "
                + methodName + " with arguments: "
                + Arrays.toString(args) + " and exception: " + exception);
    }

    @Around("bankAccountPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("Around before executing method: "
                + methodName + " with arguments: "
                + Arrays.toString(args));

        var customBankAccount1 =
                new BankAccount("Custom Bank 1", 500.0 );
        var customBankAccount2 =
                new BankAccount("Custom Bank 2", 300.0 );

        Object result =
                joinPoint.proceed(new Object[]{customBankAccount1, customBankAccount2,100.0});

        System.out.println("Around after executing method: "
                + methodName + " with arguments: "
                + Arrays.toString(args) + " and result: " + result);

        return result;
    }
}
