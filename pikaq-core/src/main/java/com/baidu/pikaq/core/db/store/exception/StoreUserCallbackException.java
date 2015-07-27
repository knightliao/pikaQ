package com.baidu.pikaq.core.db.store.exception;

/**
 * Created by knightliao on 15/7/7.
 */
public class StoreUserCallbackException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StoreUserCallbackException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public StoreUserCallbackException(String exceptionMessage, Throwable throwable) {

        super(exceptionMessage, throwable);
    }
}
