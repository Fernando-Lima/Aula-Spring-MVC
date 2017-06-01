package com.fernandolima.gerenciamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fernandolima.gerenciamento.model.Fibra;
import com.fernandolima.gerenciamento.repository.GenericRepository;

@Controller
@RequestMapping("/comissao")
public class InstalacaoController {
	
	@Autowired
	private GenericRepository genericRepository;

	@RequestMapping
	public String pesquisarComissao() {
		return "Comissao";
	}

	@RequestMapping("/instalacaoFibra")
	public String instalacaoFibra() {
		return "TabelaInstalacaoFibra";
	}

	@RequestMapping("/instalacaoFibra/novo")
	public ModelAndView novaInstalacaoFibra() {
		ModelAndView mv = new ModelAndView("CadastroInstalacaoFibra");
		return mv;
	}

	@RequestMapping("/upgradeFibra")
	public String UpgradeFibra() {
		return "TabelaUpgradeFibra";
	}

	@RequestMapping("/upgradeFibra/novo")
	public String novaUpgradeFibra() {
		return "CadastroUpgradeFibra";
	}

	@RequestMapping("/instalacaoRadio")
	public String instalacaoRadio() {
		return "TabelaInstalacaoRadio";
	}

	@RequestMapping("/instalacaoRadio/novo")
	public String novaInstalacaoRadio() {
		return "CadastroInstalacaoRadio";
	}
	
	@RequestMapping("/cliente")
	public String pesquisarCliente(){
		return "TabelaCliente";
	}

	@RequestMapping(value="/instalacaoFibra", method = RequestMethod.POST)
	public ModelAndView salvarFibra(Fibra fibra) {
		genericRepository.save(fibra);
		ModelAndView mv = new ModelAndView("CadastroInstalacaoFibra");
		mv.addObject("mensagemInstalacao","instalação salva com sucesso!");
		return mv;
	}
}
