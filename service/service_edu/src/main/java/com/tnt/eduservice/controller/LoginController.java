package com.tnt.eduservice.controller;

import com.tnt.commonutils.Res;
import com.tnt.eduservice.entity.vo.UserLoginParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description 登录接口
 * @createTime 2022年07月19日 16:36:00
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class LoginController {

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Res login(@RequestBody UserLoginParam userLoginParam){
        return Res.ok().data("token","simulateToken");
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getUserinfo")
    public Res getUserInfo(){
        return Res.ok().data("roles","[admin]").data("name","admin").data("avatar","i`am avatar");
    }


}
