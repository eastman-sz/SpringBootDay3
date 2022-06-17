package com.omfine.service;

import com.omfine.bean.User;

import java.util.List;

public interface UserService {

    int insert(User user);

    List<User> selectList();

}
