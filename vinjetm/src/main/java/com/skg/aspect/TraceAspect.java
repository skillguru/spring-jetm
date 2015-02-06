package com.skg.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

/**
 * A trace aspect for your classes. When enabled, 
 * you can figure out the execution flow in your application 
 *
 */
@Aspect
public class TraceAspect {

	protected Log log = LogFactory.getLog(this.getClass());
	
	public Object traceAdvice(ProceedingJoinPoint pjp) throws Throwable {
		if (this.log.isTraceEnabled()) {
			this.log
					.trace(">>> Entering " + this.getInvocationDescription(pjp));
		}

		log.info("Entering >> "+this.getInvocationDescription(pjp));
		Object retVal = pjp.proceed();
		log.info("Exiting >> "+this.getInvocationDescription(pjp));
		
		return retVal;
	}
	
	private String getInvocationDescription(ProceedingJoinPoint pjp) {
		
		return "method '" + pjp.getSignature().getName() + "' of class ["
				+ pjp.getTarget().getClass().getName() + "]";
	}



}