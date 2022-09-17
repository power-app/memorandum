package com.example.memorandum.controller;

import com.example.memorandum.entity.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yeah
 * @create 2022/9/8
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private static ArrayList<Teacher> teachers = new ArrayList<>();

    @GetMapping
    public List<Teacher> getTeacher() {
        return teachers;
    }

    @PostMapping
    public Map<String, Object> add(Teacher teacher) {

        long id = UUID.randomUUID().getMostSignificantBits();
        teacher.setId(id);

        teachers.add(teacher);

        Map<String, Object> map = new Hashtable<>();
        map.put("code", 200);
        map.put("msg", "添加成功！");
        return map;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Teacher teacher) {

        int top = 0;
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                top = i;
            }
        }

        teachers.set(top, teacher);

        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        int top = 0;
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                top = i;
            }
        }
        teachers.remove(top);
        return "删除成功";

    }

    @GetMapping("/search")
    public List<Teacher> search(String name) {
        List results = new ArrayList();
        Pattern pattern = Pattern.compile(name);

        for (int i = 0; i < teachers.size(); i++) {
            Matcher matcher = pattern.matcher(((Teacher) teachers.get(i)).getName());
            if (matcher.find()) {
                results.add(teachers.get(i));
            }
        }
        return results;
    }


}
