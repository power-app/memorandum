package com.example.memorandum.mapper;

import com.example.memorandum.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yeah
 * @create 2022/9/9
 */
@Mapper
public interface TeacherMapper {

    List<Teacher> getAll();

    int create(Teacher teacher);

    int update(Teacher teacher);

    int delete(Long id);
}
