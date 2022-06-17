package com.omfine.bean;

import lombok.Data;

@Data
public class ResultBean<T> {

    int result = 1;
    T data;

}
