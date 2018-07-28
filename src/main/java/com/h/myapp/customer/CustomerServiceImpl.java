package com.h.myapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.h.myapp.order.OrderRepository;
import com.h.myapp.util.Result;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Value("${my.defaultPageSize}")
	private Integer pageSize;

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Result<Customer> toPage(Integer toPage) {
		// TODO Auto-generated method stub
		Page<Customer> page = customerRepository.findAll(PageRequest.of(toPage, pageSize, Direction.ASC, "customerId"));
		int totalPage = page.getTotalPages() - 1;
		Result<Customer> result = new Result<Customer>();

		result.setResultList(page.getContent());
		result.setFirstPage("/customer/toPage/0");
		result.setPrePage("/customer/toPage/" + (toPage > 0 ? toPage - 1 : toPage));
		result.setNextPage("/customer/toPage/" + (toPage < totalPage ? toPage + 1 : totalPage));
		result.setLastPage("/customer/toPage/" + totalPage);
		return result;
	}

	@Override
	public Result<Customer> search(Integer toPage,String type, String param) {
		// TODO Auto-generated method stub
		Page<Customer> page=null;
		Pageable pageable=PageRequest.of(toPage, pageSize, Direction.ASC, "customerId");
		switch(type){
		case "byNikeName":
			page=customerRepository.findByCustomerNikeNameContaining(param, pageable);
			break;
		case "byName":
			page=customerRepository.findByCustomerNameContaining(param, pageable);
			break;
		case "byCountry":
			page=customerRepository.findByCustomerCountryContaining(param, pageable);
			break;
		case "byEmail":
			page=customerRepository.findByCustomerEmailContaining(param, pageable);
			break;
		}
		
		int totalPage = page.getTotalPages() - 1;
		Result<Customer> result = new Result<Customer>();

		result.setResultList(page.getContent());
		result.setFirstPage("/customer/toPage/0/by/"+type+"/search/"+param);
		result.setPrePage("/customer/toPage/" + (toPage > 0 ? toPage - 1 : toPage)+"/by/"+type+"/search/"+param);
		result.setNextPage("/customer/toPage/" + (toPage < totalPage ? toPage + 1 : totalPage)+"/by/"+type+"/search/"+param);
		result.setLastPage("/customer/toPage/" + totalPage+"/by/"+type+"/search/"+param);
		return result;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
		return "删除成功";
	}

	@Override
	public Integer getOrderNum(Integer id) {
		// TODO Auto-generated method stub
		return orderRepository.countByCustomer_customerId(id);
	}

}
