package com.h.myapp.goods;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h.myapp.goodsandsupplier.GoodsAndSupplier;

@RestController
@Scope("prototype")
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	// 展示所有产品,第一页

	@GetMapping("/toPage/{toPage}")
	
	public Map<String, Object> toPage(@PathVariable Integer toPage) {
		return goodsService.toPage(toPage-1);
	}

	@GetMapping("/{goodsId}/getSupplier")
	
	public List<GoodsAndSupplier> getSupplierById(@PathVariable Integer goodsId) {
		return goodsService.getSupplier(goodsId);
	}

	@PostMapping("/{goodsId}/delete")
	
	public boolean deleteGoodsById(@PathVariable Integer goodsId) {
		return goodsService.deleteById(goodsId);
	}

	@PostMapping("/save/info")
	
	public Goods saveInfo(Goods goods) {
		return goodsService.saveInfo(goods);
	}

	@PostMapping("/save/pic")
	
	public Goods savePic(Goods goods, @PathParam("file") Part file) throws Exception {
		return goodsService.savePic(goods, file);
	}

	//////////// 旧的api
	@GetMapping("/toPage/{toPage}/search/{param}")
	
	public Map<String, Object> toPageSearch(@PathVariable Integer toPage, @PathVariable String param, Model model) {
		return goodsService.toPageSearch(toPage-1, param);

	}

}
