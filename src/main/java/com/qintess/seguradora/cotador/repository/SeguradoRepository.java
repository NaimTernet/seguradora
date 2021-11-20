package com.qintess.seguradora.cotador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.seguradora.cotador.model.Segurado;

public interface SeguradoRepository extends JpaRepository<Segurado, Long> {
	Optional<Segurado> findByDocumento(long documento);
}
