package com.buchstadt.service.common;

import com.buchstadt.utils.R;

public interface LoginCallback<T> {
    R<T> success();

    R<T> failed();

    R<T> error();
}
