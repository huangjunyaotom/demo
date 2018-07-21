package com.h.myapp.customer;

import com.h.myapp.util.Result;

public interface CustomerService {
	Customer save(Customer customer);
	Result<Customer> toPage(Integer toPage);
}
