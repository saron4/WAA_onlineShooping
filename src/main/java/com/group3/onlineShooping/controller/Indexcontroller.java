package com.group3.onlineShooping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Indexcontroller {
	
	@GetMapping("/")
	public String saveit() {
		return "index";
	}

}
