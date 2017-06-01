package com.fernandolima.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandolima.gerenciamento.model.Cliente;

public interface GenericRepository extends JpaRepository<Cliente, Long>{
	
}
