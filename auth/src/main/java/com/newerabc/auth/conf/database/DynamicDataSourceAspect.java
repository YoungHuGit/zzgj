package com.newerabc.auth.conf.database;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Title DataSourceConfig
 * @author  young_____hu
 * @create  2020年05月16日
 * 切换数据源Advice
 */

@Aspect
@Component
public class DynamicDataSourceAspect {
	
	@Pointcut("execution(public * com.newerabc.auth.*.*(..))")
    public void changeDataSource() {}  
	
	@Before("@annotation(targetDataSource)")
	public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        DynamicDataSourceContextHolder.setDataSourceType(targetDataSource.value());
   }

	@After("@annotation(targetDataSource)")
	public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
		//方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
		DynamicDataSourceContextHolder.clearDataSourceType();
	}
}
