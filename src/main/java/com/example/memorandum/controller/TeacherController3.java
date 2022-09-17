package com.example.memorandum.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.memorandum.entity.Teacher;
import com.example.memorandum.service.TeacherSwevice2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author Yeah
 * @create 2022/9/9
 */
@Slf4j
@RestController
@RequestMapping("/teacher3")
public class TeacherController3 {

    @Autowired
    private TeacherSwevice2 teacherSwevice2;

    @GetMapping
    public List<Teacher> getAllTeachers(){

        return teacherSwevice2.list();
    }

    /**
     * 输入name，进行模糊搜索
     * @param teacher
     * @return
     */
    @GetMapping("/list")
    public List<Teacher> getSome(Teacher teacher){

        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(teacher.getName() != null,Teacher::getName,teacher.getName());

        List<Teacher> list = teacherSwevice2.list(queryWrapper);
        return list;
    }


    @PostMapping
    public String insertTeacher( Teacher teacher){
        log.info("教师信息：{}",teacher);
         teacherSwevice2.save(teacher);

        return "添加成功";
    }

    @PutMapping("/{id}")
    public String updateTeacher(Teacher teacher){

        teacherSwevice2.updateById(teacher);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id){
        teacherSwevice2.removeById(id);
        return "删除成功";
    }



}
