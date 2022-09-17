package com.example.memorandum.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Yeah
 * @create 2022/9/13
 */
@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class StudentParam {
    //学生表
    private String name;
    private String studentNo;
    private String sex;
    private Integer age;
    //学生卡
    private String cardNo;
    private String balance;

}
