package com.skg.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyNewTraceLoggingAspect {

	 private Logger fileLogger = Logger.getLogger("myLogger");

	    public void initialise()
	    {
	        System.out.println("Initialising SessionMonitoringAspect");
	    }

	    @Pointcut ("execution (public * *(..))")
	    private void anyPublicOperation(){
	    	
	    	System.out.println(" Any public operation executed");
	    }

	    @Pointcut ("within(my.app.session..*)")
	    private void inSession(){}

	    @Pointcut("anyPublicOperation() && inSession()")
	    private void sessionOperation(){}

	    @Before("sessionOperation()")
	    public void sessionOperationDetected(JoinPoint jp)
	    {
	        fileLogger.info("Session operation detected - signature: " + jp.getSignature());
	    }
}
