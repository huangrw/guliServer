package com.tnt.eduservice.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tnt.eduservice.entity.EduSubject;
import com.tnt.eduservice.entity.excel.ExcelSubjectData;
import com.tnt.eduservice.service.EduSubjectService;
import com.tnt.exceptionHandler.MyException;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年08月07日 23:23:00
 */
public class SubjectExcelListener extends AnalysisEventListener<ExcelSubjectData> {

    public EduSubjectService eduSubjectService;

    public SubjectExcelListener() {
    }

    //创建有参数构造，传递subjectService用于操作数据库
    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }


    @Override
    public void invoke(ExcelSubjectData excelSubjectData, AnalysisContext analysisContext) {
        if (excelSubjectData == null) {
            throw new MyException(20001, "添加失败");
        }


        EduSubject existOneSubject = this.existOneSubject(eduSubjectService, excelSubjectData.getOneSubjectName());


        if (existOneSubject == null) {//没有相同的
            existOneSubject = new EduSubject();
            existOneSubject.setTitle(excelSubjectData.getOneSubjectName());
            existOneSubject.setParentId("0");
            eduSubjectService.save(existOneSubject);
        }
        //获取一级分类id值
        String pid = existOneSubject.getId();

        //添加二级分类
        EduSubject existTwoSubject = this.existTwoSubject(eduSubjectService, excelSubjectData.getTwoSubjectName(), pid);
        if (existTwoSubject == null) {
            existTwoSubject = new EduSubject();
            existTwoSubject.setTitle(excelSubjectData.getTwoSubjectName());
            existTwoSubject.setParentId(pid);
            eduSubjectService.save(existTwoSubject);
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    //判断一级分类是否重复
    private EduSubject existTwoSubject(EduSubjectService subjectService, String
            name, String pid) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", pid);
        EduSubject eduSubject = subjectService.getOne(wrapper);
        return eduSubject;
    }


    // 判断一级分类是否重复
    private EduSubject existOneSubject(EduSubjectService subjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        EduSubject eduSubject = subjectService.getOne(wrapper);
        return eduSubject;
    }
}
