package com.skg.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingService {
	  	
		@Pointcut("execution(* *.*(..))")
	    protected void loggingOperation() {}

	    @Before("loggingOperation()")
	    public void logJoinPoint()
	    {
	        System.out.println ("Hello");
	     }
	
	
}
