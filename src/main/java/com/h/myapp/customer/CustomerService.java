package com.h.myapp.customer;

import javax.servlet.http.HttpServletResponse;

import com.h.myapp.util.Result;

public interface CustomerService {
	Customer save(Customer customer);
	Result<Customer> toPage(Integer toPage);
	Result<Customer> search(Integer toPage,String type,String param);
	String delete(Integer id);
	Integer getOrderNum(Integer id);
	void export(Integer toPage,String type,String param,HttpServletResponse response)throws Exception;
	void export(Integer toPage,HttpServletResponse response)throws Exception;
}
