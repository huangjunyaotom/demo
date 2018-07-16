package com.h.myapp.goods;

import javax.websocket.server.PathParam;

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
import org.springframework.web.multipart.MultipartFile;

@Controller
@Scope("prototype")
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	// 展示所有产品,第一页
	@GetMapping("")
	public String show(Model model) {

		return toPage(0, model);
	}

	@GetMapping("/toPage/{toPage}")
	public String toPage(@PathVariable("toPage") Integer toPage, Model model) {

		Page<Goods> page = goodsService.findAllToPage(toPage);
		int totalPage = page.getTotalPages() - 1;

		model.addAttribute("goodsList", page.getContent());
		model.addAttribute("menuShow", "/goods/manager.html");
		model.addAttribute("firstPage", "/goods/toPage/0");
		model.addAttribute("prePage", "/goods/toPage/" + (toPage > 0 ? toPage - 1 : toPage));
		model.addAttribute("nextPage", "/goods/toPage/" + (toPage < totalPage ? toPage + 1 : totalPage));
		model.addAttribute("lastPage", "/goods/toPage/" + totalPage);
		return "menu";
	}
	@GetMapping("/toPage/{toPage}/search/{param}")
	public String toPageSearch(@PathVariable Integer toPage,@PathVariable String param,Model model) {
		Page<Goods> page = goodsService.search(toPage, param);
		int totalPage = page.getTotalPages() - 1;

		model.addAttribute("goodsList", page.getContent());
		model.addAttribute("menuShow", "/goods/manager.html");
		model.addAttribute("firstPage", "/goods/toPage/0/search/"+param);
		model.addAttribute("prePage", "/goods/toPage/" + (toPage > 0 ? toPage - 1 : toPage)+"/search/"+param);
		model.addAttribute("nextPage", "/goods/toPage/" + (toPage < totalPage ? toPage + 1 : totalPage)+"/search/"+param);
		model.addAttribute("lastPage", "/goods/toPage/" + totalPage+"/search/"+param);
		
		return "menu";
		
	}
	@GetMapping("/search")
	public String search(Integer toPage,String param,Model model) {
		Page<Goods> page = goodsService.search(toPage, param);
		int totalPage = page.getTotalPages() - 1;

		model.addAttribute("goodsList", page.getContent());
		model.addAttribute("menuShow", "/goods/manager.html");
		model.addAttribute("firstPage", "/goods/toPage/0/search/"+param);
		model.addAttribute("prePage", "/goods/toPage/" + (toPage > 0 ? toPage - 1 : toPage)+"/search/"+param);
		model.addAttribute("nextPage", "/goods/toPage/" + (toPage < totalPage ? toPage + 1 : totalPage)+"/search/"+param);
		model.addAttribute("lastPage", "/goods/toPage/" + totalPage+"/search/"+param);
		
		return "menu";
		
	}
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("menuShow", "/goods/edit.html");
		return "menu";
	}

	@PostMapping("/save/info")
	public String saveInfo(Goods goods, Model model) {
		model.addAttribute("goods", goodsService.saveInfo(goods));
		model.addAttribute("menuShow", "/goods/edit.html");
		return "menu";
	}
	@PostMapping("/save/pic")
	public String savePic(Goods goods,@PathParam("file") MultipartFile file, Model model) throws Exception {
		model.addAttribute("goods", goodsService.savePic(goods,file));
		model.addAttribute("menuShow", "/goods/edit.html");
		return "menu";
	}
	
	@GetMapping("/edit/{goodsId}")
	public String edit(@PathVariable("goodsId")Integer goodsId,Model model) {
		
		model.addAttribute("goods", goodsService.getOne(goodsId));
		model.addAttribute("menuShow", "/goods/edit.html");
		return "menu"; 
	}
	
	@GetMapping("/{goodsId}")
	@ResponseBody
	public Goods get(@PathVariable("goodsId") Goods goods) {
		return goods;
	}
	
	@GetMapping("/delete/{goodsId}")
	@ResponseBody
	public String delete(@PathVariable("goodsId") Integer goodsId) {
		return goodsService.deleteById(goodsId);
		
	}
	
	
}
