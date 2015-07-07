package com.baidu.pikaq.core.db.store.exception;

/**
 *
 */
public class StoreException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StoreException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public StoreException(String exceptionMessage, Throwable throwable) {

        super(exceptionMessage, throwable);
    }
}
