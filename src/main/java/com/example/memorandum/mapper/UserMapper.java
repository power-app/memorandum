package com.example.memorandum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.memorandum.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yeah
 * @create 2022/9/13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
