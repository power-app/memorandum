package com.example.memorandum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.memorandum.entity.Classify;
import com.example.memorandum.mapper.ClassifyMapper;
import com.example.memorandum.service.ClassifyService;
import org.springframework.stereotype.Service;

/**
 * @author Yeah
 * @create 2022/9/13
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {
}
