package com.example.learn.controller;

import com.example.learn.entity.ResponseResult;
import com.example.learn.entity.User;
import com.example.learn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吴嘉豪
 * @date 2023/11/14 16:36
 */

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        // 登录
        // Authenticate 进行认证

        // 如果认证没有通过

        // 如果认证通过， 使用userid 生成一个jwt

        // 将信息存入到redis
        return loginService.login(user);
    }
    @RequestMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
