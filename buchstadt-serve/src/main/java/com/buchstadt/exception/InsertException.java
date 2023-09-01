package com.buchstadt.exception;

public class InsertException extends RuntimeException {

    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super("Insert Exception：" + message);
    }

    public InsertException(String message, Throwable cause) {
        super("Insert Exception：" + message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("Insert Exception：" + message, cause, enableSuppression, writableStackTrace);
    }

}
