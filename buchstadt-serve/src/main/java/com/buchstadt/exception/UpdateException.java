package com.buchstadt.exception;

public class UpdateException extends RuntimeException {

    public UpdateException() {
        super();
    }

    public UpdateException(String message) {
        super("Update Exception：" + message);
    }

    public UpdateException(String message, Throwable cause) {
        super("Update Exception：" + message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    protected UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("Update Exception：" + message, cause, enableSuppression, writableStackTrace);
    }

}
