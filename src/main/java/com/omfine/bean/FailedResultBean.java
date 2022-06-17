package com.omfine.bean;

import lombok.Data;

@Data
public class FailedResultBean<T> {

    int result = 0;
    T data;
    String message = null;

}
