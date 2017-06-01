package com.fernandolima.gerenciamento.model;

public enum CategoriaUsuario {
	TECNICO ("Técnico(a)"),
	SECRETARIO ("Seretário(a)"),
	GERENTE ("Gerente");
	
	private String categoria;
	
	CategoriaUsuario(String categoria) {
		this.categoria = categoria;
	}
	public String getCategoria(){
		return categoria;
	}
	
}
