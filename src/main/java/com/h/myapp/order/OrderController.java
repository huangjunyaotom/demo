package com.h.myapp.order;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping
	public String manager(Model model) {
		model.addAttribute("menuShow", "order/sended.html");
		return "menu";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("menuShow", "order/edit.html");
		return "menu";
	}
	
	@GetMapping("/prepare")
	public String prepare(Model model) {
		model.addAttribute("menuShow", "order/prepare.html");
		return "menu";
	}
}
