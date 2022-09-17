package com.example.memorandum.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.memorandum.common.Result;
import com.example.memorandum.entity.User;
import com.example.memorandum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * @author Yeah
 * @create 2022/9/13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public Result regist(@RequestBody User user) {

        return Result.success(userService.save(user));
    }


    @PostMapping("/login")
    public Result login(@Validated @RequestBody User user) {

        String password = user.getPassword();

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User usr = userService.getOne(queryWrapper);

        if (usr == null) {

            return Result.error("登陆失败");
        }
        if(!usr.getPassword().equals(password)){
            return Result.error("登陆失败");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,30);//设置过期时间

        String token = JWT.create().withAudience(usr.getId().toString(),usr.getName())
                .withExpiresAt(calendar.getTime())//获取过期时间
                .sign(Algorithm.HMAC256("ahkjsfhas"));
        return Result.success(token);
    }


}
