package com.h.myapp.goodsandsupplier;

import java.util.List;
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
@RequestMapping("/goodsAndSupplier")
public class GoodsAndSupplierController {
	@Autowired
	private GoodsAndSupplierService goodsAndSupplierService;

	@GetMapping("/goodsId/{goodsId}")
	
	public List<GoodsAndSupplier> findByGoods_goodsId(@PathVariable Integer goodsId) {
		return goodsAndSupplierService.findByGoods_goodsId(goodsId);
	}

	@PostMapping("/{id}/delete")
	
	public boolean deleteByid(@PathVariable Integer id) {
		return goodsAndSupplierService.deleteByid(id);
	}

	@PostMapping("/save")
	
	public GoodsAndSupplier save(GoodsAndSupplier goodsAndSupplier) {
		return goodsAndSupplierService.save(goodsAndSupplier);
	}


	@GetMapping("/toPage/{toPage}")
	
	public Map<String,Object> toPage(@PathVariable Integer toPage) {

		return goodsAndSupplierService.toPage(toPage-1);
	}

	@GetMapping("/toPage/{toPage}/search/{param}")
	
	public Map<String,Object> toPageSearch(@PathVariable Integer toPage,@PathVariable String param) {

		return goodsAndSupplierService.search(toPage-1, param);
	}
}
