package com.newerabc.auth.common.resp;

import lombok.Data;

/**
 * @author 胡智阳
 * @date 2020-10-03 14:12
 * @desc
 */
@Data
public class Result<T> {

    private Integer status;
    private String message;
    private T data;

}
