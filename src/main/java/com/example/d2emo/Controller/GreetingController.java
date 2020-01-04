package com.example.d2emo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			@RequestParam(value = "address", required = false, defaultValue = "Wh") String address, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		return "greeting";
	}

}