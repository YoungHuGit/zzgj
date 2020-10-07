package com.newerabc.auth.common.resp;

import com.newerabc.auth.common.Constants;

/**
 * @author 胡智阳
 * @date 2019/12/2 19:10
 * @description
 */
public class JsonResultUtil {

    public static Result sucess(Object data){
        Result result = new Result();
        result.setStatus(Constants.SUCCESS);
        result.setMessage("请求返回正常");
        result.setData(data);
        return result;
    }

    public static Result sucess(){
        return sucess(null);
    }

    public static Result error(String message){
        Result result = new Result();
        result.setStatus(Constants.ERROR);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

}
