package com.h.myapp.supplier;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;

	
	@GetMapping("/toPage/{toPage}")
	
	public Map<String,Object> toPage(@PathVariable Integer toPage) {
		return supplierService.toPage(toPage-1);
	}

	@GetMapping("/toPage/{toPage}/search/{param}")
	
	public Map<String,Object> toPageSearch(@PathVariable Integer toPage, @PathVariable String param) {
		
		return supplierService.toPageSearch(toPage-1, param);
	}

	
	@PostMapping("/save")
	
	public Supplier save(Supplier supplier) {
		return supplierService.save(supplier);
	}

	@GetMapping("/{supplierId}/countGoods")
	
	public Integer countGoods(@PathVariable Integer supplierId) {
		return supplierService.countGoods(supplierId);
	}

	@PostMapping("/{supplierId}/delete}")
	
	public boolean delete(@PathVariable Integer supplierId) {
		return supplierService.delete(supplierId);
	}
}
