package com.h.myapp.order;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServerImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRespository;
	@Override
	
	@Transactional
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return orderRespository.save(order);
	}
	@Override
	@Transactional
	public boolean changeStatus(int id, int status) {
		// TODO Auto-generated method stub
		 Order order=orderRespository.getOne(id);
		 order.setOrderStatus(status);
		 orderRespository.save(order);
		return true;
	}
	@Override
	public void getPdf(int id) {
		// TODO Auto-generated method stub
		
	}

}
