package com.example.learn;

import com.example.learn.entity.User;
import com.example.learn.mapper.UserMapper;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * @author 吴嘉豪
 * @date 2023/11/14 12:23
 */
@SpringBootTest
public class mapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void TestBCryptPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches("1234", "$2a$10$z8ZrqoQ38.N.flqHDjT7vuULL1XrKCiNX2pr0wkVa9.TpaJ3x..Py");
        System.out.println(matches);

    }
    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
