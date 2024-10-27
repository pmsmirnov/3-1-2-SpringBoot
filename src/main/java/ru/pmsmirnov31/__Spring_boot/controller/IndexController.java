package ru.pmsmirnov31.__Spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping(value = "/")
	public String printWelcome() {
		return "index";
	}
	
}