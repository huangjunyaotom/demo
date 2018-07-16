package com.h.myapp.goodsandsupplier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/goodsAndSupplier")
public class GoodsAndSupplierController {
	@Autowired
	private GoodsAndSupplierService goodsAndSupplierService;

	@GetMapping("/goodsId/{goodsId}")
	@ResponseBody
	public List<GoodsAndSupplier> findByGoods_goodsId(@PathVariable("goodsId") Integer goodsId) {
		return goodsAndSupplierService.findByGoods_goodsId(goodsId);
	}

	@GetMapping("/{id}/delete")
	@ResponseBody
	public String deleteByid(@PathVariable("id") Integer id) {
		return goodsAndSupplierService.deleteByid(id);
	}
	
	@PostMapping("/save")
	@ResponseBody
	public GoodsAndSupplier save(GoodsAndSupplier goodsAndSupplier) {
		System.out.println(goodsAndSupplier);
		return goodsAndSupplierService.save(goodsAndSupplier);
	}
}
