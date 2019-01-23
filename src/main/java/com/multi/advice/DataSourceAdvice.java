package com.multi.advice;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import com.multi.dataSource.DataSource;
import com.multi.dataSource.DataSourceContextHolder;

public class DataSourceAdvice implements MethodBeforeAdvice,AfterReturningAdvice
{

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		DataSourceContextHolder.clearDataSourceType();
	}

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
	
		if (method.isAnnotationPresent(DataSource.class)) 
		{
			DataSource datasource = method.getAnnotation(DataSource.class);
			DataSourceContextHolder.setDataSourceType(datasource.name());
		}
//		else
//		{
//			DataSourceContextHolder.setDataSourceType("dataSource1");
//		}
		
	}
}
