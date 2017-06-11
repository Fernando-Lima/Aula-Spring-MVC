package com.fernandolima.gerenciamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fernandolima.gerenciamento.model.Usuario;
import com.fernandolima.gerenciamento.repository.GenericRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private GenericRepository genericRepository; 

	@RequestMapping
	public ModelAndView pesquisarUsuario(){
		//List<Usuario> todosUsuarios = genericRepository.findAll();
		ModelAndView mv = new ModelAndView("TabelaUsuario");
		//mv.addObject("usuarios", todosUsuarios);
		return mv;
	}
	@RequestMapping("/novo")
	public ModelAndView novoUsuario(){
		ModelAndView mv = new ModelAndView("CadastroUsuario");
		mv.addObject(new Usuario());
		return mv;
	}
}
