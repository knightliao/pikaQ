/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.pikaq.core.db.commit.executor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 提交前后 base
 */
public class CommitExecutorBaseImpl extends TransactionSynchronizationAdapter implements CommitExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommitExecutorBaseImpl.class);
    protected static final ThreadLocal<List<Runnable>> RUNNABLES = new ThreadLocal<List<Runnable>>();

    /**
     * 注册到事务处理器
     *
     * @param runnable
     */
    @Override
    public void execute(Runnable runnable) {

        LOGGER.debug("Submitting new runnable {} to run after commit", runnable);

        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            LOGGER.debug("Transaction synchronization is NOT ACTIVE. Executing right now runnable {}", runnable);
            runnable.run();
            return;
        }
        List<Runnable> threadRunnables = RUNNABLES.get();
        if (threadRunnables == null) {
            threadRunnables = new ArrayList<Runnable>();
            RUNNABLES.set(threadRunnables);
            TransactionSynchronizationManager.registerSynchronization(this);
        }
        threadRunnables.add(runnable);
    }

}
