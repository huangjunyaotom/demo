package com.h.myapp.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save")
	public Order save(Order order) {
		return orderService.save(order);
	}
	
	@PostMapping("/{id}/status/{status}")
	public boolean changeStatus(@PathVariable int id,@PathVariable int status) {
		return true;
	}
	
	@GetMapping("/{id}/getPdf")
	public void getPdf(@PathVariable int id) {
		
	}
}
