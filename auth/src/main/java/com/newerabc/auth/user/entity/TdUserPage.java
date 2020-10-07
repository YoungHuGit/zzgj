package com.newerabc.auth.user.entity;

import lombok.Data;

/**
 * @author 胡智阳
 * @date 2020-10-03 15:25
 * @desc
 */
@Data
public class TdUserPage extends User {

    private int page;

    private int rows;

}
