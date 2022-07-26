package com.tnt.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description  封装返回结果
 * @createTime 2022年07月17日 23:45:00
 */
@Data
public class Res {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    // 私有化空参构造方法,外部无法使用 new 方法创建对象
    private Res(){}

    public static Res ok(){
        Res res = new Res();
        res.setSuccess(true);
        res.setCode(ResultCode.SUCCESS);
        res.setMessage("成功");
        return res;

    }


    public static Res error(){
        Res res = new Res();
        res.setSuccess(false);
        res.setCode(ResultCode.ERROR);
        res.setMessage("失败");
        return res;
    }

    public Res success(boolean success){
        this.setSuccess(success);
        return this;
    }

    public Res message(String message){
        this.setMessage(message);
        return this;
    }

    public Res code(Integer code){
        this.setCode(code);
        return this;
    }

    public Res data(String key, Object value){
        this.data.put(key,value);
        return this;
    }

    public Res data(Map<String,Object> map){
        this.setData(map);
        return this;
    }





}
