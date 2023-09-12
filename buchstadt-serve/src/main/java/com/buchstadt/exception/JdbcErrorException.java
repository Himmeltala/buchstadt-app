package com.buchstadt.exception;

import com.buchstadt.constant.ExpVals;

/**
 * @description:
 * @package: com.buchstadt.exception
 * @author: zheng
 * @date: 2023/9/4
 */
public class JdbcErrorException extends RuntimeException {

    public JdbcErrorException() {
        super(ExpVals.DB_ERROR);
    }

    public JdbcErrorException(String message) {
        super(message);
    }

    public JdbcErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public JdbcErrorException(Throwable cause) {
        super(ExpVals.DB_ERROR, cause);
    }

    protected JdbcErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
