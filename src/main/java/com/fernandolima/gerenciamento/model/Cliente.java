package com.fernandolima.gerenciamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	private String nomeCliente = "Fernando";
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nomeCliente=" + nomeCliente + "]";
	}
	public Cliente(Long codigo, String nomeCliente) {
		super();
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
