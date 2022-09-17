package com.example.memorandum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.memorandum.common.Result;
import com.example.memorandum.entity.Classify;
import com.example.memorandum.service.ClassifyService;
import com.example.memorandum.utils.LoginUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yeah
 * @create 2022/9/13
 */
@RestController
@Api()
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    @ApiOperation(value = "获取当前登录用户的分类信息")
    @GetMapping
    public Result getAll(HttpServletRequest request){

        Integer userId = LoginUtils.UserId(request);
        QueryWrapper<Classify> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);

        return Result.success(classifyService.list(queryWrapper));
    }


    @ApiOperation(value = "当前登录用户添加分类信息")
    @ApiImplicitParam(name = "name",value = "用户添加的分类名称")
    @PostMapping
    public Result add(@RequestBody Classify classify, HttpServletRequest request){
        System.out.println(classify);

        classify.setUserId(LoginUtils.UserId(request));

        return Result.success(classifyService.save(classify));

    }

    @ApiOperation(value = "当前登录用户修改分类信息")
    @ApiImplicitParam(name = "name",value = "用户修改的分类名称")
    @PutMapping
    public Result update(@RequestBody Classify classify){

        System.out.println("======="+classify);
        boolean success = classifyService.updateById(classify);
        return Result.toResult(success);
    }

    @ApiOperation(value = "当前登录用户删除分类信息")
    @ApiImplicitParam(name = "id",value = "用户根据id删除分类")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean success = classifyService.removeById(id);
        return Result.toResult(success);
    }

}
