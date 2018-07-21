package com.h.myapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.h.myapp.util.Result;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
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

}
