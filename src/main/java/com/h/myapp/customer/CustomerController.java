package com.h.myapp.customer;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
		
	@GetMapping("/toPage/{toPage}")
	
	public Map<String,Object> toPage(@PathVariable("toPage") Integer toPage){
		return customerService.toPage(toPage-1);
	}
	
	@GetMapping("/toPage/{toPage}/by/{type}/search/{param}")
	
	public Map<String,Object> toPageSsearch(
			@PathVariable("toPage") Integer toPage,
			@PathVariable("type") String type,
			@PathVariable("param") String param){
		return customerService.search(toPage-1, type, param);
	}
	
	@GetMapping("/count/{id}")
	
	public Integer countOrder(@PathVariable("id") Integer id){
		return customerService.getOrderNum(id);
	}
	@GetMapping("/{nikeName}")
	
	public List<Customer> findByNikeName(@PathVariable String nikeName) {
		return customerService.findByNikeName(nikeName);
	}
	
	@PostMapping("/save")
	
	public Customer save(Customer customer){
		return customerService.save(customer);
	}
	
	@PostMapping("/delete/{id}")
	
	public boolean delete(@PathVariable("id") Integer id){
		return customerService.delete(id);
	}
	
	@GetMapping("/toPage/{toPage}/by/{type}/search/{param}/excel")
    public void excel(
    		@PathVariable("toPage") Integer toPage,
			@PathVariable("type") String type,
			@PathVariable("param") String param,
			HttpServletResponse response) throws Exception {
        customerService.export(toPage-1, type, param, response);
    }
	
	@GetMapping("/toPage/{toPage}/excel")
    public void excel(
    		@PathVariable("toPage") Integer toPage,
			HttpServletResponse response) throws Exception {
        customerService.export(toPage-1,response);
    }
}
