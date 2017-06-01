package com.fernandolima.gerenciamento.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fernandolima.gerenciamento.model.CategoriaUsuario;
import com.fernandolima.gerenciamento.model.Cliente;
import com.fernandolima.gerenciamento.model.Fibra;
import com.fernandolima.gerenciamento.model.Usuario;
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
	public ModelAndView pesquisarCliente(){
		//List<Cliente> todosClientes = genericRepository.findAll();
		ModelAndView mv = new ModelAndView("TabelaCliente");
		//mv.addObject("clientes", todosClientes);
		return mv;
	}
	@RequestMapping("/cliente/novo")
	public ModelAndView novoCliente(){
		ModelAndView mv = new ModelAndView("CadastroCliente");
		return mv;
	}
	@RequestMapping("/usuario")
	public ModelAndView pesquisarUsuario(){
	//	List<Usuario> todosUsuarios = genericRepository.findAll();
		ModelAndView mv = new ModelAndView("TabelaUsuario");
		//mv.addObject("clientes", todosUsuarios);
		return mv;
	}
	@RequestMapping("/usuario/novo")
	public ModelAndView novoUsuario(){
		ModelAndView mv = new ModelAndView("CadastroUsuario");
		return mv;
	}

	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(Usuario usuario) {
		genericRepository.save(usuario);
		ModelAndView mv = new ModelAndView("CadastroUsuario");
		mv.addObject("mensagemInstalacao","usuario salvo com sucesso!");
		return mv;
	}
	@ModelAttribute("todasCategorias")
	public List<CategoriaUsuario> todasCategorias(){
		return Arrays.asList(CategoriaUsuario.values());
	}
}
