package com.example.memorandum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.memorandum.entity.Note;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yeah
 * @create 2022/9/16
 */
@Mapper
public interface NoteMapper extends BaseMapper<Note> {
}
