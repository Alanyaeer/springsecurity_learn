package com.example.learn.service;

import com.example.learn.entity.ResponseResult;
import com.example.learn.entity.User;

/**
 * @author 吴嘉豪
 * @date 2023/11/14 16:39
 */
public interface LoginService{
    public ResponseResult login(User user);

    ResponseResult logout();
}
