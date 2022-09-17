package com.example.memorandum.service;

import com.example.memorandum.entity.Teacher;

import java.util.List;

/**
 * @author Yeah
 * @create 2022/9/9
 */
public interface TeacherService {
    //查询全部老师
    List<Teacher> getTeacherAll();
    //添加教师
    int insert(Teacher teacher);
    //教师信息修改
    int update(Teacher teacher);
    //删除教师
    int deleteTea(Long id);

}
