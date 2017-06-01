package com.fernandolima.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandolima.gerenciamento.model.Fibra;

public interface GenericRepository extends JpaRepository<Fibra, Long>{
	
}
