package com.fernandolima.gerenciamento.model;

public enum CategoriaUsuario {
	TECNICO ("Técnico(a)"),
	SECRETARIO ("Seretário(a)"),
	GERENTE ("Gerente");
	
	private String descricao;
	
	CategoriaUsuario(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao(){
		return descricao;
	}
	
}
