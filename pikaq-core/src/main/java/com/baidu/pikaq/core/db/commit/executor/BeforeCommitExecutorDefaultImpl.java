package com.baidu.pikaq.core.db.commit.executor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 提交之前
 */
public class BeforeCommitExecutorDefaultImpl extends CommitExecutorBaseImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeforeCommitExecutorDefaultImpl.class);

    /**
     * Invoked before transaction commit
     * <p/>
     * 如果失败，会引起后面的事务 回滚
     *
     * @param readOnly
     */
    @Override
    public void beforeCommit(boolean readOnly) {

        List<Runnable> threadRunnables = RUNNABLES.get();

        LOGGER.debug("Transaction beforeCommit, executing {} runnables", threadRunnables.size());

        for (int i = 0; i < threadRunnables.size(); i++) {

            Runnable runnable = threadRunnables.get(i);
            LOGGER.debug("Executing runnable {}", runnable);
            runnable.run();
        }
    }

    /**
     * Invoked before transaction commit/rollback
     */
    @Override
    public void beforeCompletion() {

        LOGGER.debug("Transaction beforeCompletion");
        RUNNABLES.remove();
    }

}
