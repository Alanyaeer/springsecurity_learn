package com.example.learn.service.impl;

import com.example.learn.entity.LoginUser;
import com.example.learn.entity.ResponseResult;
import com.example.learn.entity.User;
import com.example.learn.service.LoginService;
import com.example.learn.utils.JwtUtil;
import com.example.learn.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author 吴嘉豪
 * @date 2023/11/14 16:39
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 判断上面这个是不是为null， 如果为null 说明没有通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);

        // 认证通过
        // authenticate.getPrincipal()
        // 把完整用户信息存入到redis 中
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);
        redisCache.setCacheObject("login: " + userid , loginUser);
        return new ResponseResult(200, "登录成功", jwt);
    }

    @Override
    public ResponseResult logout() {
        // 获取securityContextHolder 中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        Long userid =loginUser.getUser().getId();
        redisCache.deleteObject("login: "+userid);
        // 删除redis当中的值
        return new ResponseResult(200, "注销成功");
    }
}
