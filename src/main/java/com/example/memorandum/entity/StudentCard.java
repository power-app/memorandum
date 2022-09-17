package com.example.memorandum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Yeah
 * @create 2022/9/9
 */
@Data
@AllArgsConstructor
@Component
@NoArgsConstructor

public class StudentCard {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer studentId;
    private String cardNo;
    private String createDate;
    private String balance;
    private String active;
}
