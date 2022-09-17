package com.example.memorandum.entity;

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
public class StudentVo {

    private Integer id;
    private String name;
    private String cardNo;
    private String balance;


}
