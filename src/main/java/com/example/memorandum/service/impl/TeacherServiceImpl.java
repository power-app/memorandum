package com.example.memorandum.service.impl;

import com.example.memorandum.entity.Teacher;
import com.example.memorandum.mapper.TeacherMapper;
import com.example.memorandum.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yeah
 * @create 2022/9/9
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getTeacherAll() {
        return teacherMapper.getAll();
    }

    @Override
    public int insert(Teacher teacher) {
        return teacherMapper.create(teacher);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    public int deleteTea(Long id) {
        return teacherMapper.delete(id);
    }
}
