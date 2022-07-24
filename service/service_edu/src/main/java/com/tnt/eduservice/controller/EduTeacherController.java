package com.tnt.eduservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tnt.commonutils.Res;
import com.tnt.eduservice.entity.EduTeacher;
import com.tnt.eduservice.entity.vo.TeacherQueryParam;
import com.tnt.eduservice.service.EduTeacherService;
import com.tnt.exceptionHandler.MyException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 讲师 前端控制器
 * @author tnt
 * @since 2022-07-17
 */
@Slf4j
@RestController
@RequestMapping("/eduservice/edu-teacher")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    //1. 查询所有讲师的信息
    @ApiOperation("查询所有讲师信息")
    @GetMapping("findAll")
    public Res findAllTeacher(){
        try {
            System.out.println(1/0);
        }catch (Exception e){
            log.warn("出现错误");
            throw new MyException(2002,"出现自定义异常");
        }

        List<EduTeacher> teachers = teacherService.list(null);
        return Res.ok().data("item",teachers);
    }

    // 2. 逻辑删除教师
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("{id}")
    public Res deleteTeacher(@PathVariable String id){
        boolean delRes = teacherService.removeById(id);
        if (delRes) {
            return Res.ok();
        }
        return Res.error();

    }

    // 3.分页查询
    @ApiOperation(value = "分页教师列表")
    @GetMapping("yt/{page}/{limit}")
    public Res pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){

        Page<EduTeacher> pageParam =  new Page<>(page, limit);

        teacherService.page(pageParam, null);

        List<EduTeacher> records = pageParam.getRecords();
        long total = ((IPage<?>) pageParam).getTotal();
        return Res.ok().data("total", total).data("rows", records);
    }

    // 4.分页条件查询
    @ApiOperation("分页条件查询讲师")
    @PostMapping("/{page}/{limit}")
    public Res teacherQyeryByCondition(@PathVariable Long page, @PathVariable Long limit, @RequestBody(required = false) TeacherQueryParam teacherRequestParam){

        Page<EduTeacher> teachers = new Page<>(page, limit);

        teacherService.pageQuery(teachers,teacherRequestParam);

        long total = teachers.getTotal();
        List<EduTeacher> records = teachers.getRecords();

        return Res.ok().data("total", total).data("rows", records);
    }


    @ApiOperation("新增讲师")
    @PostMapping("/addTeacher")
    public  Res addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean saveRes = teacherService.save(eduTeacher);
        if (saveRes){
            return Res.ok().message("添加成功");
        }
        return Res.error().message("添加失败");
    }

    @ApiOperation("根据 Id 查询讲师")
    @PostMapping("/{id}")
    public Res getTeacherById(@PathVariable Long id){
        EduTeacher teacher = teacherService.getById(id);
        return Res.ok().data("teacher",teacher);
    }

    @ApiOperation("根据 Id 修改教师信息")
    @PutMapping("/update")
    public Res updateTeacherById(@RequestBody EduTeacher teacher){

        boolean updateRes = teacherService.updateById(teacher);

        if (updateRes){
            return Res.ok().message("修改成功");
        }
        return Res.error().message("修改失败");
    }


}

