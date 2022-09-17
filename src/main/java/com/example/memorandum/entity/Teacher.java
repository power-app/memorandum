package com.example.memorandum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Yeah
 * @create 2022/9/8
 */
@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private String sex;
    private String age;
}
