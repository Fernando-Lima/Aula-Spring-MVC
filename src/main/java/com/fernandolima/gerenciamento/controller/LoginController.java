package com.fernandolima.gerenciamento.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping
	public String paginaInicial() {
		return "Login";
	}
	@RequestMapping("/dashboard")
	public String dashboard(){
		return "index";
	}
	@RequestMapping("/comissao")
	public String comissao(){
		return "Comissao";
	}

}
