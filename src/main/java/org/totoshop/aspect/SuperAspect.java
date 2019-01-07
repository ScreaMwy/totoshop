package org.totoshop.aspect;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.ProceedingJoinPoint;

@Component("superAspect")
@Scope(scopeName = "singleton")
@Aspect
public class SuperAspect {
	public SuperAspect() {}
	
	@Pointcut("execution(* org.totoshop.service.impl.*ServiceImpl.*(..))")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void beforeAdvice() {
		System.out.printf("%s\n", "Before Advice");
	}
	
	@Around("pointcut()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = pjp.proceed();
		System.out.printf("%s\n", "Around Advice");
		return obj;
	}
	
	@After("pointcut()")
	public void afterAdvice() {
		System.out.printf("%s\n", "After Advice");
	}
	
	@AfterReturning("pointcut()")
	public void afterReturningAdvice() {
		System.out.printf("%s\n", "AfterReturning Advice");
	}
	
	@AfterThrowing("pointcut()")
	public void afterThrowingAdvice() {
		System.out.printf("%s\n", "AfterThrowing Advice");
	}
}
