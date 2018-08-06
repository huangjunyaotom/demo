package com.h.myapp.order;

public interface OrderService {
	Order save(Order order);
	boolean changeStatus(int id,int status);
	void getPdf(int id);
}
