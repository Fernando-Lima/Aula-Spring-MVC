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
@RequestMapping("/comissao")
public class InstalacaoController {
	private static final String CADASTRO_CLIENTE_VIEW = "CadastroCliente";
	
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
		List<Cliente> todosClientes = genericRepository.findAll();
		ModelAndView mv = new ModelAndView("TabelaCliente");
		mv.addObject("clientes", todosClientes);
		return mv;
	}
	@RequestMapping("/cliente/novo")
	public ModelAndView novoCliente(){
		ModelAndView mv = new ModelAndView(CADASTRO_CLIENTE_VIEW);
		mv.addObject(new Cliente());
		return mv;
	}
	@RequestMapping("/usuario")
	public ModelAndView pesquisarUsuario(){
		//List<Usuario> todosUsuarios = genericRepository.findAll();
		ModelAndView mv = new ModelAndView("TabelaUsuario");
		//mv.addObject("usuarios", todosUsuarios);
		return mv;
	}
	@RequestMapping("/usuario/novo")
	public ModelAndView novoUsuario(){
		ModelAndView mv = new ModelAndView("CadastroUsuario");
		mv.addObject(new Usuario());
		return mv;
	}

	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public String salvar(@Validated Cliente cliente, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()){
			return "CadastroCliente";
		}
		
		genericRepository.save(cliente);
		attributes.addFlashAttribute("mensagemInstalacao","Cliente salvo com sucesso!");
		return "redirect:/comissao/cliente/novo";
	}
	
	@RequestMapping("/cliente/{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Cliente cliente){
		ModelAndView mv = new ModelAndView(CADASTRO_CLIENTE_VIEW);
		mv.addObject(cliente);
		return mv;
	}
	@RequestMapping(value="/cliente/{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		genericRepository.delete(codigo);
		return "redirect:/comissao/cliente";
	}
	
	@ModelAttribute("todasCategorias")
	public List<CategoriaUsuario> todasCategorias(){
		return Arrays.asList(CategoriaUsuario.values());
	}
}
