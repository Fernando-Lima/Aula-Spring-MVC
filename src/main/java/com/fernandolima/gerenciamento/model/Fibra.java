package com.fernandolima.gerenciamento.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Fibra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nomeCliente;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataInstalacao;

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

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
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
		Fibra other = (Fibra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Fibra(Long codigo, String nomeCliente, Date dataInstalacao) {
		super();
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
		this.dataInstalacao = dataInstalacao;
	}

	public Fibra() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Fibra [codigo=" + codigo + ", nomeCliente=" + nomeCliente + ", dataInstalacao=" + dataInstalacao + "]";
	}

}
