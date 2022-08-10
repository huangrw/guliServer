package com.tnt.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年08月07日 23:20:00
 */
@Data
public class ExcelSubjectData {

    @ExcelProperty(index = 0)
    private String oneSubjectName;

    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
