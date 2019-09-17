package com.mysqlaccess;

import java.util.List;

public interface OnGetComplete<T> {
    void onSuccess(T data);
    void onFailure();
}
