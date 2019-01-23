package com.multi.service;

import java.util.List;

import com.multi.dataSource.DataSource;
import com.multi.entity.Customer;

public interface CustomerService {

	@DataSource(name=DataSource.dataSource1)
	public List<Customer> find1();
	
	@DataSource(name=DataSource.dataSource2)
	public List<Customer> find2();
	
	@DataSource(name=DataSource.dataSource1)
	public void save1(Customer entity);
	
	@DataSource(name=DataSource.dataSource2)
	public void save2(Customer entity);
	
	public void save(Customer entity1, Customer entity2, int num);
}
