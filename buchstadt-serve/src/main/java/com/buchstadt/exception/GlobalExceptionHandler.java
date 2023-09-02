package com.buchstadt.exception;

import com.buchstadt.utils.Http;
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
    public R<String> handleBindException(BindException e) {
        BindingResult r = e.getBindingResult();
        StringBuilder message = new StringBuilder();
        for (FieldError fieldError : r.getFieldErrors()) {
            message.append(fieldError.getDefaultMessage());
        }
        log.error(e.getMessage(), e);
        return R.build(Http.ERROR, message.toString());
    }

    @ExceptionHandler({RuntimeException.class})
    public R<String> handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return R.build(Http.ERROR, e.getMessage());
    }

}
