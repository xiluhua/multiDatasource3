

package com.multi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.dao.CustomerDao;
import com.multi.dataSource.DataSource;
import com.multi.entity.Customer;
import com.multi.service.CustomerService;

@Transactional
@Service
public class CustomerImpl implements CustomerService{

	@Resource
	CustomerImpl customerImpl;
	
	@Autowired
	private CustomerDao customerDao;
	
	@DataSource(name=DataSource.dataSource1)
	public List<Customer> find1(){
		return customerDao.find1();
	}
	
	@DataSource(name=DataSource.dataSource2)
	public List<Customer> find2(){
		return customerDao.find2();
	}
	
	@DataSource(name=DataSource.dataSource1)
	public void save1(Customer entity) {
		customerDao.save1(entity);
	}
	
	@DataSource(name=DataSource.dataSource2)
	public void save2(Customer entity) {
		customerDao.save2(entity);
	}
	
	/**
	 * 反例：一次代理不能支持开启两个数据源
	 * @author xilh
	 * @since 20190123
	 */
	public void save(Customer entity1, Customer entity2, int num) {
		customerImpl.save1(entity1);
		
		System.out.println("tmp: "+ 10/num);
		
		customerImpl.save2(entity2);
	}
}
