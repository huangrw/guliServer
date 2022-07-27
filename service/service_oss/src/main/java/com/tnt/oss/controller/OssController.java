package com.tnt.oss.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.tnt.commonutils.Res;
import com.tnt.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年07月27日 23:34:00
 */
@RestController
@Slf4j
@RequestMapping("/eduoss/fileoss")
@Api(tags = "ossController")
public class OssController {

    @Autowired
    OssService ossService;

    @PostMapping
    @ApiOperation("上传图像接口")
    public Res uploadOssFile(MultipartFile file){

        // 获取文件

        // 上传后返回路径
        String url = ossService.uploadFileAvatar(file);

        return Res.ok().data("url",url);


    }





}
