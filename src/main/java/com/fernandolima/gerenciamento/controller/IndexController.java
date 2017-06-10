package com.fernandolima.gerenciamento.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class IndexController {

	@RequestMapping
	public String dashboard(){
		return "index";
	}

}
