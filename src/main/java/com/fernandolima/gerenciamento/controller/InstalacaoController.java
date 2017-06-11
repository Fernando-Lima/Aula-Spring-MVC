package com.fernandolima.gerenciamento.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fernandolima.gerenciamento.model.CategoriaUsuario;
import com.fernandolima.gerenciamento.model.Cliente;
import com.fernandolima.gerenciamento.model.Fibra;
import com.fernandolima.gerenciamento.model.Usuario;
import com.fernandolima.gerenciamento.repository.GenericRepository;

@Controller
@RequestMapping("/instalacao")
public class InstalacaoController {
	
	@Autowired
	private GenericRepository genericRepository;

	@RequestMapping("/fibra")
	public String pesquisarFibra() {
		return "TabelaInstalacaoFibra";
	}

	@RequestMapping("/fibra/novo")
	public ModelAndView novaInstalacaoFibra() {
		ModelAndView mv = new ModelAndView("CadastroInstalacaoFibra");
		return mv;
	}
/*--------------------------------------------------------------------------------------------------------------*/
	
	
	@RequestMapping("/upgradeFibra")
	public String UpgradeFibra() {
		return "TabelaUpgradeFibra";
	}

	@RequestMapping("/upgradeFibra/novo")
	public String novaUpgradeFibra() {
		return "CadastroUpgradeFibra";
	}

	@RequestMapping("/radio")
	public String instalacaoRadio() {
		return "TabelaInstalacaoRadio";
	}

	@RequestMapping("/radio/novo")
	public String novaInstalacaoRadio() {
		return "CadastroInstalacaoRadio";
	}
	
	@ModelAttribute("todasCategorias")
	public List<CategoriaUsuario> todasCategorias(){
		return Arrays.asList(CategoriaUsuario.values());
	}
}
