package com.qintess.seguradora.cotador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.seguradora.cotador.model.Segurado;

public interface CotadorRepository extends JpaRepository<Segurado, Long>{
	Segurado findById(long id);
	
	
	

}
