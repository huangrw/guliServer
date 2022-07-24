package com.tnt.eduservice.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description  用户登录请求参数
 * @createTime 2022年07月19日 16:40:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户登录请求参数")
public class UserLoginParam {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}
