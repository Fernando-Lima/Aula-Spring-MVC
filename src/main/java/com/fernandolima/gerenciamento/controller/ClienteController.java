package com.fernandolima.gerenciamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fernandolima.gerenciamento.model.Cliente;
import com.fernandolima.gerenciamento.repository.GenericRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	private static final String CADASTRO_CLIENTE_VIEW = "CadastroCliente";
	
	@Autowired
	private GenericRepository genericRepository;

	@RequestMapping
	public ModelAndView pesquisarCliente(){
		List<Cliente> todosClientes = genericRepository.findAll();
		ModelAndView mv = new ModelAndView("TabelaCliente");
		mv.addObject("clientes", todosClientes);
		return mv;
	}
	@RequestMapping("/novo")
	public ModelAndView novoCliente(){
		ModelAndView mv = new ModelAndView(CADASTRO_CLIENTE_VIEW);
		mv.addObject(new Cliente());
		return mv;
	}
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public String salvar(@Validated Cliente cliente, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()){
			return "CadastroCliente";
		}
		genericRepository.save(cliente);
		attributes.addFlashAttribute("mensagemInstalacao","Cliente salvo com sucesso!");
		return "redirect:/cliente/novo";
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Cliente cliente){
		ModelAndView mv = new ModelAndView(CADASTRO_CLIENTE_VIEW);
		mv.addObject(cliente);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		genericRepository.delete(codigo);
		return "redirect:/cliente";
	}
}
