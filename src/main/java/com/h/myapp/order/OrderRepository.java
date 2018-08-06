package com.h.myapp.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

	Integer countByCustomer_customerId(Integer customerId);
	boolean updateOrderStatusById(int id,int orderStatus);
}
