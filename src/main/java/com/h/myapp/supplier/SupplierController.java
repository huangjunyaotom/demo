package com.h.myapp.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
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
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;

	@GetMapping("")
	public String show(Result<Supplier> result,Model model) {
		model.addAttribute("menuShow", "/supplier/manager.html");
		return "menu";
	}

	@GetMapping("/toPage/{toPage}")
	@ResponseBody
	public Result<Supplier> toPage(@PathVariable("toPage") Integer toPage, Result<Supplier> result) {
		Page<Supplier> page = supplierService.findAllToPage(toPage);
		int totalPage = page.getTotalPages() - 1;
		result.setResultList(page.getContent());
		result.setFirstPage("/supplier/toPage/0");
		result.setPrePage("/supplier/toPage/" + (toPage > 0 ? toPage - 1 : toPage));
		result.setNextPage("/supplier/toPage/" + (toPage < totalPage ? toPage + 1 : totalPage));
		result.setLastPage("/supplier/toPage/" + totalPage);
		return result;
	}

	@GetMapping("/toPage/{toPage}/search/{param}")
	@ResponseBody
	public Result<Supplier> toPageSearch(@PathVariable Integer toPage, @PathVariable String param,
			Result<Supplier> result) {
		Page<Supplier> page = supplierService.search(toPage, param);
		int totalPage = page.getTotalPages() - 1;

		result.setResultList(page.getContent());
		result.setFirstPage("/supplier/toPage/0/search/" + param);
		result.setPrePage("/supplier/toPage/" + (toPage > 0 ? toPage - 1 : toPage) + "/search/" + param);
		result.setNextPage("/supplier/toPage/" + (toPage < totalPage ? toPage + 1 : totalPage) + "/search/" + param);
		result.setLastPage("/supplier/toPage/" + totalPage + "/search/" + param);
		return result;
	}
	
	@PostMapping("/save")
	@ResponseBody
	public Supplier save(Supplier supplier) {
//		System.out.println(supplier);
		return supplierService.save(supplier);
	}
	
	@GetMapping("/count/{supplierId}")
	@ResponseBody
	public Integer countGoods(@PathVariable Integer supplierId) {
		return supplierService.countGoods(supplierId);
	}
	
	@GetMapping("/delete/{supplierId}")
	@ResponseBody
	public String delete(@PathVariable Integer supplierId) {
		return supplierService.delete(supplierId);
	}
}
