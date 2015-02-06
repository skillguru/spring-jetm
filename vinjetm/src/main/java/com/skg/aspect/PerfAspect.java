package com.skg.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

/**
 * 
 */

public class PerfAspect {

	private final EtmMonitor etmMonitor;

	public PerfAspect(EtmMonitor etmMonitor) {
		this.etmMonitor = etmMonitor;
	}

	private String getInvocationDescription(ProceedingJoinPoint pjp) {
		StringBuilder builder = new StringBuilder();
		builder.append(pjp.getTarget().getClass().getName()).append(".");
		builder.append(pjp.getSignature().getName());
		System.out.println("In perf aspect ::> " +builder);
		return builder.toString();
	}


	public Object perfAdvice(ProceedingJoinPoint pjp) throws Throwable {

		EtmPoint point = this.etmMonitor.createPoint(this
				.getInvocationDescription(pjp));
		try {
			return pjp.proceed();
		}
		finally {
			point.collect();
		}
	}
}
