package com.multi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.multi.entity.Customer;
import com.multi.service.CustomerService;

public class Main2 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 初始化基础数据
		long a = System.currentTimeMillis();
		CustomerService service = (CustomerService)ctx.getBean("customerImpl");
		
		Customer entity1 = new Customer("师傅A",50);
		entity1.setId(359);
		service.save1(entity1);
		
		Customer entity2 = new Customer("师傅B",51);
		entity2.setId(360);
		service.save2(entity2);
		
		// 反例：一次代理不能支持开启两个数据源
		// service.save(entity1, entity2, 1);
		long z = System.currentTimeMillis();
		z = (z-a);
		System.out.println("测试结束。。。。用时："+z+"毫秒");
	}
	
}



