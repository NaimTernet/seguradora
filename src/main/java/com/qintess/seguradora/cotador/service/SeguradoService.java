package com.qintess.seguradora.cotador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.seguradora.cotador.model.Segurado;
import com.qintess.seguradora.cotador.repository.SeguradoRepository;

@Service
public class SeguradoService {
	@Autowired
	private SeguradoRepository seguradoRepository;

	public List<Segurado> findAll() {
		return seguradoRepository.findAll();
	}

	public Segurado save(Segurado segurado) {
		// find by id para recuperar o Segurado e verificar se ele ja existe na base
		//se ele existir na base (validar se o documento e o nome sao os mesmos ja gravados na base 
		//senao for (se for diferente) retornar uma Exception 
		return seguradoRepository.save(segurado);
	}
}
