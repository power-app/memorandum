package com.example.memorandum.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.memorandum.common.Result;
import com.example.memorandum.entity.Note;
import com.example.memorandum.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yeah
 * @create 2022/9/16
 */
@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    /**
     * 保存列表信息
     * @param note
     * @return
     */
    @PostMapping
    public Result addNote(@RequestBody Note note){

        boolean save = noteService.save(note);

        return Result.toResult(save);
    }

    @GetMapping
    public Page page(int pageNum,int pageSize){
        //创建分页构造器
        Page page = new Page(pageNum,pageSize);
        //创建条件构造器
        LambdaQueryWrapper<Note> queryWrapper = new LambdaQueryWrapper<>();
        //设置排序
        queryWrapper.orderByDesc(Note::getCreateTime);

        noteService.page(page,queryWrapper);
        return page;
    }

    @GetMapping("/search")
    public Result queryNote(Note note){
        LambdaQueryWrapper<Note> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(note.getNoteTitle() != null,Note::getNoteTitle,note.getNoteTitle());

        List<Note> list = noteService.list(queryWrapper);
        return Result.success(list);

    }

    //列表信息的删除
    @DeleteMapping("/{id}")
    public Result deleteNoteByid(@PathVariable Integer id){

        boolean remove = noteService.removeById(id);

        return Result.toResult(remove);

    }

}
