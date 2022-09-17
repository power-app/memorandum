package com.example.memorandum.controller;

import com.example.memorandum.entity.Teacher;
import com.example.memorandum.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author Yeah
 * @create 2022/9/9
 */
@RestController
@RequestMapping("/teacher2")
public class TeacherController2 {

    @Autowired
    private TeacherService teacherService;
    //查询所有教师
    @GetMapping
    public List<Teacher> queryAll(){
        return teacherService.getTeacherAll();
    }

    //添加教师
    @PostMapping
    public Map<String,Object> insertTeacher(Teacher teacher){

        int row = teacherService.insert(teacher);

        Map<String,Object> map = new Hashtable<>();
        if (row > 0){
            map.put("code",200);
            map.put("msg","添加成功！");
        }else{
            map.put("code",500);
            map.put("msg","添加失败！");
        }
    return map;
    }

    @PutMapping("/{id}")
    public Map<String,Object> updateTeacher(Teacher teacher){

        int row = teacherService.update(teacher);

        Map<String,Object> map = new Hashtable<>();
        if (row > 0){
            map.put("code",200);
            map.put("msg","修改成功！");
        }else{
            map.put("code",500);
            map.put("msg","修改失败！");
        }

        return map;
    }

    @DeleteMapping("/{id}")
    public Map<String,Object> deleteTeacher(@PathVariable Long id){

        int row = teacherService.deleteTea(id);

        Map<String,Object> map = new Hashtable<>();
        if (row > 0){
            map.put("code",200);
            map.put("msg","删除成功！");
        }else{
            map.put("code",500);
            map.put("msg","删除失败！");
        }

        return map;
    }




}
