package com.baidu.pikaq.core.db.commit.inner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by knightliao on 15/6/29.
 */
public class PjpCommitRunnable implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(PjpCommitRunnable.class);

    private final ProceedingJoinPoint pjp;

    public PjpCommitRunnable(ProceedingJoinPoint pjp) {
        this.pjp = pjp;
    }

    @Override
    public void run() {
        try {
            pjp.proceed();
        } catch (Throwable e) {
            LOGGER.error("Exception while invoking pjp.proceed()", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        String typeName = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        return "PjpAfterCommitRunnable[type=" + typeName + ", method=" + methodName + "]";
    }
}