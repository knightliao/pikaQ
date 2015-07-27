package com.baidu.pikaq.core.db.commit.executor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 提交之后
 */
public class AfterCommitExecutorDefaultImpl extends CommitExecutorBaseImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(AfterCommitExecutorDefaultImpl.class);

    /**
     * Invoked after transaction commit. Can perform further operations right after the main transaction has
     * successfully committed.
     * 只有事务成功时才会调用。 如果本函数 执行失败 不会回滚了
     */
    @Override
    public void afterCommit() {

        List<Runnable> threadRunnables = RUNNABLES.get();

        LOGGER.debug("Transaction successfully committed, executing {} runnables", threadRunnables.size());

        for (int i = 0; i < threadRunnables.size(); i++) {

            Runnable runnable = threadRunnables.get(i);
            LOGGER.debug("Executing runnable {}", runnable);
            try {
                runnable.run();
            } catch (RuntimeException e) {
                LOGGER.error("Failed to execute runnable " + runnable, e);
            }
        }
    }

    /**
     * Invoked after transaction commit/rollback. Can perform resource cleanup after transaction completion.
     * <p/>
     * 不管回滚还是提交，都会被执行
     *
     * @param status
     */
    @Override
    public void afterCompletion(int status) {

        LOGGER.debug("Transaction completed with status {}", status == STATUS_COMMITTED ? "COMMITTED" : "ROLLED_BACK");
        RUNNABLES.remove();
    }

}
