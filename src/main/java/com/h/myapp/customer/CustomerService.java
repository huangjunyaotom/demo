package com.h.myapp.customer;

import com.h.myapp.util.Result;

public interface CustomerService {
	Customer save(Customer customer);
	Result<Customer> toPage(Integer toPage);
	Result<Customer> search(Integer toPage,String type,String param);
	String delete(Integer id);
	Integer getOrderNum(Integer id);
}
