package com.h.myapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h.myapp.util.Result;

@Controller
@Scope("prototype")
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("menuShow", "customer/manager.html");
		return "menu";
	}
	
	@GetMapping("/new")
	public String newCustomer(Model model) {
		model.addAttribute("menuShow", "customer/edit.html");
		return "menu";
	}
	
	@PostMapping("/save")
	@ResponseBody
	public Customer save(Customer customer){
		return customerService.save(customer);
	}
	
	@GetMapping("/toPage/{toPage}")
	@ResponseBody
	public Result<Customer> toPage(@PathVariable("toPage") Integer toPage){
		return customerService.toPage(toPage);
	}
}
