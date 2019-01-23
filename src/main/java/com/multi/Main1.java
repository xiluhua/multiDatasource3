package com.multi;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.multi.entity.Customer;
import com.multi.service.CustomerService;

public class Main1 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 初始化基础数据
		long a = System.currentTimeMillis();
		CustomerService service = (CustomerService)ctx.getBean("customerImpl");
		
		List<Customer> result2 = service.find2();
		System.out.println("size2  : "+result2.size());
		System.out.println("result2: "+JSON.toJSONStringWithDateFormat(result2, "yyyy-MM-dd hh:mm:ss"));
		System.out.println();
		System.out.println();
		System.out.println();
		
		List<Customer> result1 = service.find1();
		System.out.println("size1  : "+result1.size());
		System.out.println("result1: "+JSON.toJSONStringWithDateFormat(result1, "yyyy-MM-dd hh:mm:ss"));
		System.out.println();
		System.out.println();
		System.out.println();
		
		long z = System.currentTimeMillis();
		z = (z-a);
		System.out.println("测试结束。。。。用时："+z+"毫秒");
	}
	
}



