package com.fernandolima.gerenciamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/precadastro")
public class ContratoController {

	@RequestMapping
	public ModelAndView precadastro(){
		ModelAndView mv = new ModelAndView("Precadastro");
		return mv;
	}
}
