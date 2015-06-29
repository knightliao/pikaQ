package com.baidu.pikaq.core.db.commit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baidu.pikaq.core.db.commit.executor.CommitExecutor;
import com.baidu.pikaq.core.db.commit.inner.PjpCommitRunnable;

/**
 * 事务拦截器，在事务提交前做
 */
@Aspect
@Component
public class BeforeCommitAnnotationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeforeCommitAnnotationAspect.class);

    private final CommitExecutor beforeCommitExecutor = CommitExecutorFactory.getBeforeCommitDefaultImpl();

    @Around(value = "@annotation(com.baidu.pikaq.core.db.commit.BeforeCommit)", argNames = "pjp")
    public Object aroundAdvice(final ProceedingJoinPoint pjp) {
        beforeCommitExecutor.execute(new PjpCommitRunnable(pjp));
        return null;
    }

}
