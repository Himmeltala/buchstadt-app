package com.buchstadt.exception;

import com.buchstadt.constant.ExpVals;

public class JdbcFailedException extends Exception {

    public JdbcFailedException() {
        super(ExpVals.DB_FAILED);
    }

    public JdbcFailedException(String message) {
        super(message);
    }

    public JdbcFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JdbcFailedException(Throwable cause) {
        super(ExpVals.DB_FAILED, cause);
    }

    protected JdbcFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
