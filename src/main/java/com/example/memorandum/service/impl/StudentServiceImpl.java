package com.example.memorandum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.memorandum.entity.Student;
import com.example.memorandum.entity.StudentCard;
import com.example.memorandum.mapper.StudentMapper;
import com.example.memorandum.service.StudentCardService;
import com.example.memorandum.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Yeah
 * @create 2022/9/9
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {


    @Autowired
    private StudentCardService cardService;


//    @Override
//    public List queryStudentMsg(Long id) {
//
//        List<Object> list = new ArrayList<>();
//
//        list.add(this.getById(id));
//
////        list.add(cardService.getById(id));
//        QueryWrapper<StudentCard> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("card_no","balance").eq("id",id);
//        list.add(cardService.getOne(queryWrapper));
//
//        return list;
//    }

//    @Override
//    public boolean inserStudentMsg(Student student, StudentCard studentCard) {
//
//        studentCard.setStudentId(student.getStudentNo());
//
//        boolean save1 = this.save(student);
//        boolean save = cardService.save(studentCard);
//
//        if (save1 == true && save == true){
//            return true;
//        }
//        return false;
//    }

}
