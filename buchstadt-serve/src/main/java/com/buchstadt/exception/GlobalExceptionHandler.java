package com.buchstadt.exception;

import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BindException.class})
    public R<Object> handleBindException(BindException e) {
        BindingResult r = e.getBindingResult();
        StringBuilder message = new StringBuilder();
        for (FieldError fieldError : r.getFieldErrors()) {
            message.append(fieldError.getDefaultMessage());
        }
        log.error("BindException [{}: {}]", e.getClass().getName(), message);
        return R.build(HttpCodes.ERROR, "BindException：" + message);
    }

    @ExceptionHandler({UpdateException.class, InsertException.class})
    public R<Object> handleUpdateException(UpdateException e) {
        log.error("JdbcException [{}: {}]", e.getClass().getName(), e.getMessage());
        return R.build(HttpCodes.ERROR, e.getMessage());
    }

}
