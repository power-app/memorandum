package com.example.memorandum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.memorandum.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yeah
 * @create 2022/9/9
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
