package com.buchstadt.service.common;

import com.buchstadt.utils.R;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginValidator<T> {

    private Integer userId;

    public R<T> validate(LoginCallback<T> fn) {
        if (this.userId == 0) {
            return fn.failed();
        } else {
            try {
                return fn.success();
            } catch (Exception e) {
                e.printStackTrace();
                return fn.error();
            }
        }
    }

}
