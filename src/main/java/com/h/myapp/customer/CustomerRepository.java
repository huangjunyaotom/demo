package com.h.myapp.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	Page<Customer> findByCustomerNikeNameContaining(String customerNikeName,Pageable pageable);
	Page<Customer> findByCustomerNameContaining(String customerName,Pageable pageable);
	Page<Customer> findByCustomerCountryContaining(String customerCountry,Pageable pageable);
	Page<Customer> findByCustomerEmailContaining(String customerEmail,Pageable pageable);
	
	
	
}
