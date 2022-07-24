package com.tnt.exceptionHandler;

import com.tnt.commonutils.Res;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huangrw
 * @program: guli_parent
 * @Description 全局异常处理类
 * @createTime 2022年07月18日 19:17:00
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @Author huangrw
     * @Description 统一异常处理
     * @Date 20:30 2022/7/18
     * @Param [e]
     * @return com.tnt.commonutils.Res
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Res error(Exception e){
        e.printStackTrace();
        return Res.error().message("执行统一异常处理");
    }


    /**
     * @Author huangrw
     * @Description 特定异常处理
     * @Date 20:36 2022/7/18
     * @Param [e]
     * @return com.tnt.commonutils.Res
     **/
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Res error(ArithmeticException e){
        e.printStackTrace();
        return Res.error().message("执行特定异常处理");
    }


    /**
     * @Author huangrw
     * @Description 自定义异常处理
     * @Date 20:37 2022/7/18
     * @Param [e]
     * @return com.tnt.commonutils.Res
     **/
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Res error(MyException e){
        e.printStackTrace();
        return Res.error().message(e.getMsg()).code(e.getCode());
    }
}
