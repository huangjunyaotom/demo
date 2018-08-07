package com.h.myapp.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.h.myapp.order.OrderRepository;
import com.h.myapp.util.excel.ExcelData;
import com.h.myapp.util.excel.ExportExcelUtils;

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
	public Map<String,Object> toPage(Integer toPage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Customer> page = customerRepository.findAll(PageRequest.of(toPage, pageSize, Direction.ASC, "customerId"));
		int totalPage = page.getTotalPages();
		map.put("list", page.getContent());
		map.put("totalPage", totalPage);
		return map;
	}

	@Override
	public Map<String,Object> search(Integer toPage,String type, String param) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
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
		
		int totalPage = page.getTotalPages();
		map.put("list", page.getContent());
		map.put("totalPage", totalPage);
		return map;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
		return true;
	}

	@Override
	public Integer getOrderNum(Integer id) {
		// TODO Auto-generated method stub
		return orderRepository.countByCustomer_customerId(id);
	}

	@Override
	public void export(Integer toPage, String type, String param, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Page<Customer> page=null;
		Pageable pageable=PageRequest.of(0, (1+toPage)*pageSize, Direction.ASC, "customerId");
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
		
		List<Customer> customerList=page.getContent();
		List<String> titles=new ArrayList<String>();
		titles.add("网名");
		titles.add("姓名");
		titles.add("国家");
		titles.add("邮箱");
		titles.add("地址");
		titles.add("电话");
		titles.add("邮编");
		titles.add("备注");
		List<List<Object>> rows=new ArrayList();
		for(Customer c : customerList) {
			List<Object> row=new ArrayList();
			row.add(c.getCustomerNikeName());
			row.add(c.getCustomerName());
			row.add(c.getCustomerCountry());
			row.add(c.getCustomerEmail());
			row.add(c.getCustomerAddress());
			row.add(c.getCustomerTel());
			row.add(c.getCustomerPostCode());
			row.add(c.getNote());
			
			rows.add(row);
		}
		
		ExcelData data=new ExcelData();
		data.setTitles(titles);
		data.setRows(rows);
		
		ExportExcelUtils.exportExcel(response, "客户.xlsx", data);
	}

	@Override
	public void export(Integer toPage, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Pageable pageable=PageRequest.of(0, (1+toPage)*pageSize, Direction.ASC, "customerId");
		Page<Customer> page=customerRepository.findAll(pageable);
		
		List<Customer> customerList=page.getContent();
		List<String> titles=new ArrayList<String>();
		titles.add("网名");
		titles.add("姓名");
		titles.add("国家");
		titles.add("邮箱");
		titles.add("地址");
		titles.add("电话");
		titles.add("邮编");
		titles.add("备注");
		List<List<Object>> rows=new ArrayList();
		for(Customer c : customerList) {
			List<Object> row=new ArrayList();
			row.add(c.getCustomerNikeName());
			row.add(c.getCustomerName());
			row.add(c.getCustomerCountry());
			row.add(c.getCustomerEmail());
			row.add(c.getCustomerAddress());
			row.add(c.getCustomerTel());
			row.add(c.getCustomerPostCode());
			row.add(c.getNote());
			
			rows.add(row);
		}
		
		ExcelData data=new ExcelData();
		data.setTitles(titles);
		data.setRows(rows);
		
		ExportExcelUtils.exportExcel(response, "客户.xlsx", data);
	}

	@Override
	public List<Customer> findByNikeNameContaining(String nikeName) {
		// TODO Auto-generated method stub
		Pageable pageable=PageRequest.of(0, 20, Direction.ASC, "customerId");
		return customerRepository.findByCustomerNikeNameContaining(nikeName, pageable).getContent();
	}

}
