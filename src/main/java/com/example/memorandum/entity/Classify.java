package com.example.memorandum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yeah
 * @create 2022/9/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classify {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String name;
}
