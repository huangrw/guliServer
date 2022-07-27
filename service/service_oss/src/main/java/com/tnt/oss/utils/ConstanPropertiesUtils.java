package com.tnt.oss.utils;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description
 * @createTime 2022年07月27日 23:20:00
 */
@Component
public class ConstanPropertiesUtils implements InitializingBean {   //用spring的 InitializingBean 的 afterPropertiesSet 来初始化配置信息，这个方法将在所有的属性被初始化 后调用。

    @Value("${aliyun.oos.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oos.file.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oos.file.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oos.file.bucketName}")
    private String bucketName;


    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    public static String FILE_HOST ;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = accessKeyId;
        ACCESS_KEY_SECRET = accessKeySecret;
        BUCKET_NAME = bucketName;



    }
}
