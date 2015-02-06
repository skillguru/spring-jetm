package com.skg.aspect.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * I call this performance aspect wrapper but this could 
 * be your regular aspect which might have cross 
 * cutting concerns 
 *
 */
@Aspect
public class PerfAspectWrapper {

	
	
	//@Pointcut("execution (* com.skg.jetm..*(..))")
	@Pointcut("execution (* com.skg.jetm.dao..*(..))")
	public void middleTier() { /* Empty */
		
	}
	


}
