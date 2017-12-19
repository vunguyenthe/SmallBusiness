package com.small.business.aop.monitor;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.small.business.annotations.Monitor;

@Aspect
@Component
public class ExecutionTimeMonitor {

    private static final Logger LOGGER = LoggerFactory.getLogger("monitor");

    @Value("${monitor.timeConsumeThreshold:3}")
    private long timeConsumeThreshold;

    @Around("execution(@com.small.business.annotations.Monitor * *(..)) && @annotation(monitorAnnotation)")
    public Object monitor(ProceedingJoinPoint proceedingJoinPoint, Monitor monitorAnnotation) throws Throwable {

        StopWatch sw = new StopWatch();
        try {
            sw.start();
            return proceedingJoinPoint.proceed();
        } finally {
            sw.stop();
            if ((sw.getTime() / 1000) >= timeConsumeThreshold) {
                LOGGER.info(
                        "A response for " + buildSignature(proceedingJoinPoint, monitorAnnotation) + " took " + (sw.getTime() / 1000) + " (s).");
            }
        }
    }

    private String buildSignature(ProceedingJoinPoint proceedingJoinPoint, Monitor monitorAnnotation) {

        if (StringUtils.isNotEmpty(monitorAnnotation.value())) {
            return monitorAnnotation.value();
        }
        return proceedingJoinPoint.getSignature().toString();
    }

}
