package com.baidu.pikaq.core.db.commit;

import com.baidu.pikaq.core.db.commit.executor.AfterCommitExecutorDefaultImpl;
import com.baidu.pikaq.core.db.commit.executor.BeforeCommitExecutorDefaultImpl;
import com.baidu.pikaq.core.db.commit.executor.CommitExecutor;

/**
 * Created by knightliao on 15/6/29.
 */
public class CommitExecutorFactory {

    /**
     * @return
     */
    public static CommitExecutor getAfterCommitDefaultImpl() {
        return new AfterCommitExecutorDefaultImpl();
    }

    /**
     * @return
     */
    public static CommitExecutor getBeforeCommitDefaultImpl() {
        return new BeforeCommitExecutorDefaultImpl();
    }
}