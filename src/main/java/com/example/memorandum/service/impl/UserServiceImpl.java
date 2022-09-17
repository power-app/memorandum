package com.example.memorandum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.memorandum.entity.User;
import com.example.memorandum.mapper.UserMapper;
import com.example.memorandum.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Yeah
 * @create 2022/9/13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
