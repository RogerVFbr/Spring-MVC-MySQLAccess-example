package com.mysqlaccess;

public interface OnComplete<T> {
    void onSuccess(T feedback);
    void onFailure();
}
