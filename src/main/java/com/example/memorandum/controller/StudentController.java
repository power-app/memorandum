package com.example.memorandum.controller;

import com.example.memorandum.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yeah
 * @create 2022/9/8
 */
@RestController
@RequestMapping("/student")
public class StudentController {
/*
    @GetMapping("list")
    public List<Student> getList(){
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1001,"张三","男",28));
        students.add(new Student(1002,"张三","男",28));
        students.add(new Student(1003,"张三","男",28));

        return students;
    }
*/

    @GetMapping("/test1")
    public boolean test1(String name,String sex,Integer age){
        System.out.println(name);
        System.out.println(sex);
        System.out.println(age);

        return true;

    }


    @GetMapping("/test2")
    public boolean test2(Student student){
        System.out.println(student.getName());
        System.out.println(student.getSex());
        System.out.println(student.getAge());

        return true;

    }


}
