package com.h.myapp.orderdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h.myapp.orderdetails.OrderDetails;
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {

	
}
