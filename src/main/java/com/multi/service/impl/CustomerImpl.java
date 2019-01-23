

package com.multi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.dao.CustomerDao;
import com.multi.entity.Customer;
import com.multi.service.CustomerService;

@Transactional
@Service
public class CustomerImpl implements CustomerService{
	
	@Resource(name="customerImpl")
	CustomerService customerService;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> find1(){
		return customerDao.find1();
	}
	
	@Override
	public List<Customer> find2(){
		return customerDao.find2();
	}

	@Override
	public void save1(Customer entity) {
		customerDao.save1(entity);
	}

	@Override
	public void save2(Customer entity) {
		customerDao.save2(entity);
	}
	
	@Override
	public void save(Customer entity1, Customer entity2, int num) {
		customerService.save1(entity1);
		
		System.out.println("tmp: "+ 10/num);
		
		customerService.save2(entity2);
	}
}
