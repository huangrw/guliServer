package com.tnt.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tnt.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tnt.eduservice.entity.vo.TeacherQueryParam;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author tnt
 * @since 2022-07-17
 */
public interface EduTeacherService extends IService<EduTeacher> {

     void pageQuery(Page<EduTeacher> page, TeacherQueryParam teacherRequestParam);
}
