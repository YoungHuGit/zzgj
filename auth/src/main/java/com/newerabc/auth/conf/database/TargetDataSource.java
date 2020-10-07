
package com.newerabc.auth.conf.database;

import java.lang.annotation.*;

/**
* @Title TargetDataSource
* @author dailq 
* @create  2017年12月18日
*/

@Target({ ElementType.METHOD, ElementType.TYPE ,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
	String value();
}

