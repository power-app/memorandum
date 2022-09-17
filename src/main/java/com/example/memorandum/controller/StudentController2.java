package com.example.memorandum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.memorandum.common.Result;
import com.example.memorandum.entity.Student;
import com.example.memorandum.entity.StudentCard;
import com.example.memorandum.entity.StudentParam;
import com.example.memorandum.entity.StudentVo;
import com.example.memorandum.service.StudentCardService;
import com.example.memorandum.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yeah
 * @create 2022/9/9
 */
@RestController
@Api
@RequestMapping("/student2")
public class StudentController2 {

   @Autowired
   private StudentService studentService;
   @Autowired
   private StudentCardService studentCardService;

    //查询所有学生
    @ApiOperation(value = "查询所有学生")
    @GetMapping
    public Result getStudent(){
        return Result.success(studentService.list());
    }

    //添加学生
    @ApiOperation(value = "添加学生")
    @ApiImplicitParams({
            @ApiImplicitParam(name="studentNo",value="学号",dataType="string", paramType = "query",example="1001"),
            @ApiImplicitParam(name="id",value="sql主键id",dataType="int", paramType = "query",example="1"),
            @ApiImplicitParam(name="name",value="学生姓名",dataType="string", paramType = "query",example="xingguo"),
            @ApiImplicitParam(name="sex",value="学生性别",dataType="string", paramType = "query",example="男"),
            @ApiImplicitParam(name="age",value="学生年龄",dataType="int", paramType = "query",example="28")})
    @PostMapping
    public String insert(Student student){
        studentService.save(student);
        return "ok";
    }
    //修改学生信息
    @ApiOperation(value = "修改学生信息")
    @ApiImplicitParam(name="id",value = "学生sql中的主键id值")
    @PutMapping("/{id}")
    public String update(Student student){
        studentService.updateById(student);
        return "ok";
    }
    //删除学生
    @ApiOperation(value = "删除学生信息")
    @ApiImplicitParam(name="id",value = "学生sql中的主键id值")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        studentService.removeById(id);
        return "ok";
    }

    /**
     *
     * @param id 根据id查询学生以及学生卡信息
     * @return
     */
    @GetMapping("/msg/{id}")
    public StudentVo queryStudent(@PathVariable Long id){
//        return  studentService.queryStudentMsg(id);

        Student student = studentService.getById(id);
        QueryWrapper<StudentCard> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("card_no","balance").eq("id",id);
        StudentCard studentCard = studentCardService.getOne(queryWrapper);

        StudentVo studentVo = new StudentVo();
        studentVo.setId(student.getId());
        studentVo.setName(student.getName());
        studentVo.setCardNo(studentCard.getCardNo());
        studentVo.setBalance(studentCard.getBalance());

        return studentVo;

    }


    /**
     * 添加学生和学生卡信息
     */
    @PostMapping("/add")
    public Result addStudentMsg(StudentParam studentParam){
//        return studentService.inserStudentMsg(student,studentCard);

        //添加学生
        Student student = new Student();
        student.setName(studentParam.getName());
        student.setStudentNo(studentParam.getStudentNo());
        student.setSex(studentParam.getSex());
        student.setAge(studentParam.getAge());
        studentService.save(student);

        //添加学生卡表
        StudentCard studentCard = new StudentCard();
        studentCard.setCardNo(studentParam.getStudentNo());
        studentCard.setBalance(studentParam.getBalance());
        studentCard.setStudentId(student.getId());
        boolean success = studentCardService.save(studentCard);

        return Result.toResult(success);


    }



}
