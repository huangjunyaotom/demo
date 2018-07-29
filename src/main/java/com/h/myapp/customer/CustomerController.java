package com.h.myapp.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.h.myapp.util.excel.ExcelData;
import com.h.myapp.util.excel.ExportExcelUtils;

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
		
	@GetMapping("/toPage/{toPage}")
	@ResponseBody
	public Result<Customer> toPage(@PathVariable("toPage") Integer toPage){
		return customerService.toPage(toPage);
	}
	
	@GetMapping("/toPage/{toPage}/by/{type}/search/{param}")
	@ResponseBody
	public Result<Customer> search(
			@PathVariable("toPage") Integer toPage,
			@PathVariable("type") String type,
			@PathVariable("param") String param){
		return customerService.search(toPage, type, param);
	}
	
	@GetMapping("/count/{id}")
	@ResponseBody
	public Integer countOrder(@PathVariable("id") Integer id){
		return customerService.getOrderNum(id);
	}

	@PostMapping("/save")
	@ResponseBody
	public Customer save(Customer customer){
		return customerService.save(customer);
	}
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") Integer id){
		return customerService.delete(id);
	}
	
	@GetMapping("/toPage/{toPage}/by/{type}/search/{param}/excel")
    public void excel(
    		@PathVariable("toPage") Integer toPage,
			@PathVariable("type") String type,
			@PathVariable("param") String param,
			HttpServletResponse response) throws Exception {
        customerService.export(toPage, type, param, response);
    }
	
	@GetMapping("/toPage/{toPage}/excel")
    public void excel(
    		@PathVariable("toPage") Integer toPage,
			HttpServletResponse response) throws Exception {
        customerService.export(toPage,response);
    }
}