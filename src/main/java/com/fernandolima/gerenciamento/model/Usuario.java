package com.fernandolima.gerenciamento.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	@Enumerated(EnumType.STRING)
	private CategoriaUsuario categoriaUsuario;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CategoriaUsuario getCategoriaUsuario() {
		return categoriaUsuario;
	}
	public void setCategoriaUsuario(CategoriaUsuario categoriaUsuario) {
		this.categoriaUsuario = categoriaUsuario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	public Usuario(Long codigo, String nome, CategoriaUsuario categoriaUsuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.categoriaUsuario = categoriaUsuario;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
