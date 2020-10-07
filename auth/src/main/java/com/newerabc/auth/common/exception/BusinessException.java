package com.newerabc.auth.common.exception;

import lombok.Data;

/**
 * @author 胡智阳
 * @date 2020-10-03 16:06
 * @desc
 */

@Data
public class BusinessException extends RuntimeException{

    private Integer code;
    private String msg;

    public BusinessException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
