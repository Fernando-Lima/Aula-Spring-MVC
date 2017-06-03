package com.fernandolima.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandolima.gerenciamento.model.Cliente;
import com.fernandolima.gerenciamento.model.Usuario;

public interface GenericRepository extends JpaRepository<Cliente, Long>{
	
}
