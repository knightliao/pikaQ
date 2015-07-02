package com.baidu.pikaq.client;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baidu.pikaq.core.db.commit.CommitExecutorFactory;
import com.baidu.pikaq.core.db.commit.executor.CommitExecutor;
import com.baidu.pikaq.core.db.store.StoreFactory;
import com.baidu.pikaq.core.db.store.StoreResolver;
import com.baidu.pikaq.utils.ThreadContext;

/**
 * Created by knightliao on 15/7/2.
 */
@Aspect
@Component
public class PikaAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PikaAspect.class);

    public static final String PIKAQ_DATA_DATA_KEY = "pikaq-data-data-key";
    public static final String PIKAQ_DATA_CORRELATION_KEY = "pikaq-data-data-key";

    // pikaq data 存储方案
    private StoreResolver storeResolver = StoreFactory.getDebStoreImpl();

    // 提交前设置
    private CommitExecutor beforeCommitExecutor = CommitExecutorFactory.getBeforeCommitDefaultImpl();

    @Around(value = "@annotation(com.baidu.pikaq.client.PikaQ)", argNames = "pjp")
    public Object aroundAdvice(final ProceedingJoinPoint pjp) {

        // get dta
        final Object data = ThreadContext.getContext(PIKAQ_DATA_DATA_KEY);
        final Object correlation = ThreadContext.getContext(PIKAQ_DATA_CORRELATION_KEY);

        // save data before commit
        if (data instanceof String && correlation instanceof String) {
            beforeCommitExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    storeResolver.resolve((String) correlation, (String) data);
                }
            });
        }

        // clean data
        ThreadContext.remove(PIKAQ_DATA_DATA_KEY);
        ThreadContext.remove(PIKAQ_DATA_CORRELATION_KEY);

        return null;
    }

    /**
     * 发送Q消息
     *
     * @param correlation
     * @param data
     */
    private void sendQ(String correlation, String data) {

    }

}
