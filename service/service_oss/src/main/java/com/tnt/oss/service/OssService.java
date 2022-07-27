package com.tnt.oss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年07月27日 23:33:00
 */
public interface OssService {

    // 上传图像接口
    String uploadFileAvatar(MultipartFile file);
}
