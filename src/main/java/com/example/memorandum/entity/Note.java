package com.example.memorandum.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Yeah
 * @create 2022/9/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @TableId(type = IdType.AUTO)
    @JsonProperty("noteId")
    private Integer id;
    private String noteTitle;
    private Integer top;
    private String noteContent;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
