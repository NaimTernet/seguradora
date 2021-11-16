package com.qintess.seguradora.cotador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.seguradora.cotador.model.Segurado;

public interface SeguradoRepository extends JpaRepository<Segurado, Long>{
	Segurado findById(long id);
	List<Segurado> findBydocumento(long documento);
	
	

}
