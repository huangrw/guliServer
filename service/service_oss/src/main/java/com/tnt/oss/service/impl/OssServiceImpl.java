package com.tnt.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyuncs.exceptions.ClientException;
import com.tnt.oss.service.OssService;
import com.tnt.oss.utils.ConstanPropertiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年07月27日 23:34:00
 */

@Slf4j
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {

        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = ConstanPropertiesUtils.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstanPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstanPropertiesUtils.ACCESS_KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = ConstanPropertiesUtils.BUCKET_NAME;

        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt
        // 获取文件名称
        String originalFilename = file.getOriginalFilename();

        log.info("文件名:{}",originalFilename);


        String objectName = "guli/avatar/"+originalFilename;


        log.info("文件全路径:{}",objectName);


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


        try {
            // 上传文件流
            //InputStream inputStream = new FileInputStream(filePath);
            InputStream inputStream = file.getInputStream();

            // 创建PutObject请求,实现上传
            ossClient.putObject(bucketName, objectName, inputStream);

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (Exception ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
            return null;
        } finally {
            // 关闭资源
            if (ossClient != null) {
                ossClient.shutdown();
            }

            // 手动拼接生产的 url
            String url =  "https://blogpic2022.oss-cn-guangzhou.aliyuncs.com/"+objectName;
            return url;
        }

    }
}
