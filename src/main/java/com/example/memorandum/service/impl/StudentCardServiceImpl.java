package com.example.memorandum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.memorandum.entity.StudentCard;
import com.example.memorandum.mapper.StudentCardMapper;
import com.example.memorandum.service.StudentCardService;
import org.springframework.stereotype.Service;

/**
 * @author Yeah
 * @create 2022/9/9
 */
@Service
public class StudentCardServiceImpl extends ServiceImpl<StudentCardMapper,StudentCard> implements StudentCardService{
}
