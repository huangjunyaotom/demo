package com.h.myapp.order;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h.myapp.customer.Customer;
import com.h.myapp.customer.CustomerRepository;

@Service
public class OrderServerImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRespository;
	@Autowired
	private CustomerRepository customerRespository;
	@Override
	
	@Transactional
	public Order save(Order order) {
		// TODO Auto-generated method stub
		if (order.getOrderNo() == null || order.getOrderNo().length() == 0) {
			order.setOrderNo(noUtilService.getNo("Order"));
		}
		
		Customer customer=customerRespository.findByCustomerNikeName(order.getCustomer().getCustomerNikeName());
		if(customer == null) {
			customer=new Customer();
			customer.setCustomerNikeName(order.getCustomer().getCustomerNikeName());
		}
		//更新客户信息
		customer.setCustomerAddress(order.getOrderAddress());
		customer.setCustomerCountry(order.getOrderCountry());
		customer.setCustomerEmail(order.getOrderEmail());
		customer.setCustomerName(order.getOrderName());
		customer.setCustomerPostCode(order.getOrderPostCode());
		customer.setCustomerTel(order.getOrderTel());
		customer=customerRespository.save(customer);
		//设置订单客户
		order.setCustomer(customer);
		
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
