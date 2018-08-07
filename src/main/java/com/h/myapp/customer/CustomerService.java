package com.h.myapp.customer;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface CustomerService {
	Customer save(Customer customer);
	Map<String,Object> toPage(Integer toPage);
	Map<String,Object> search(Integer toPage,String type,String param);
	boolean delete(Integer id);
	Integer getOrderNum(Integer id);
	void export(Integer toPage,String type,String param,HttpServletResponse response)throws Exception;
	void export(Integer toPage,HttpServletResponse response)throws Exception;
	List<Customer> findByNikeNameContaining(String nikeName);
}
