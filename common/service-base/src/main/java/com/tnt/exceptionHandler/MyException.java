package com.tnt.exceptionHandler;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PipedReader;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年07月18日 20:33:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("异常信息")
public class MyException extends RuntimeException {
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("提示信息")
    private String msg;
}
