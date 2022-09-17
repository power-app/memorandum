package com.example.memorandum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * @author Yeah
 * @create 2022/9/8
 */
@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
@ApiModel("学生实体类")
public class Student implements Serializable {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("学生sql中的主键id值")
    private Integer id;
    @ApiModelProperty("学生学号")
    private String studentNo;
    @ApiModelProperty("学生姓名")
    private String name;
    @ApiModelProperty("学生性别")
    private String sex;
    @ApiModelProperty("学生年龄")
    private Integer age;

}
