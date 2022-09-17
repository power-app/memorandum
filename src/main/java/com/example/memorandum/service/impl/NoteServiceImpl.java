package com.example.memorandum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.memorandum.entity.Note;
import com.example.memorandum.mapper.NoteMapper;
import com.example.memorandum.service.NoteService;
import org.springframework.stereotype.Service;

/**
 * @author Yeah
 * @create 2022/9/16
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {
}
