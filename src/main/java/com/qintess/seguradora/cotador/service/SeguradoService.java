package com.qintess.seguradora.cotador.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.seguradora.cotador.dto.SeguradoDto;
import com.qintess.seguradora.cotador.model.Segurado;
import com.qintess.seguradora.cotador.repository.SeguradoRepository;

@Service
public class SeguradoService {
	@Autowired
	private SeguradoRepository seguradoRepository;

	public List<SeguradoDto> findAll() {
		List<SeguradoDto> seguradoDtos = seguradoRepository.findAll().stream()
				.map(segurado -> SeguradoDto.toSeguradoDto(segurado)).collect(Collectors.toList());
		return seguradoDtos;
	}

	public SeguradoDto findById(Long id) {
		return seguradoRepository.findById(id).map(segurado -> SeguradoDto.toSeguradoDto(segurado))
				.orElseThrow(() -> new RuntimeException("Erro ao buscar segurado pelo ID: " + id));
	}

	public SeguradoDto save(SeguradoDto seguradoDto) {
		Optional<Segurado> seguradoOptional = seguradoRepository.findById(seguradoDto.getId());
		if (seguradoOptional.isPresent()) {
			Segurado segurado = seguradoOptional.get();
			validarDocumentoENome(seguradoDto, segurado);
			seguradoRepository.save(seguradoDto.toSegurado());
		}
		Segurado segurado = seguradoRepository.save(seguradoDto.toSegurado());
		return SeguradoDto.toSeguradoDto(segurado);
	}

	private void validarDocumentoENome(SeguradoDto seguradoDto, Segurado segurado) {
		if (!segurado.getDocumento().equals(seguradoDto.getDocumento())) {
			throw new RuntimeException(
					"O documento do Segurado nao pode ser alterado. O documento enviado " + seguradoDto.getDocumento()
							+ " é diferente do documento salvo na base " + segurado.getDocumento());
		}
		if (!segurado.getNome().equals(seguradoDto.getNome())) {
			throw new RuntimeException("O nome do Segurado nao pode ser alterado. O nome enviado "
					+ seguradoDto.getNome() + " é diferente do nome salvo na base " + segurado.getNome());
		}
	}

	public Segurado delete(Segurado segurado) {
		// find by id para recuperar o Segurado e verificar se ele ja existe na base
		// se ele existir na base (validar se o documento e o nome sao os mesmos ja
		// gravados na base
		// senao for (se for diferente) retornar uma Exception
		return seguradoRepository.save(segurado);
	}

	public SeguradoDto findByDocumento(long documento) {
		SeguradoDto seguradoDto = seguradoRepository.findByDocumento(documento)
				.map(segurado -> SeguradoDto.toSeguradoDto(segurado))
				.orElseThrow(() -> new RuntimeException("Erro ao buscar segurado pelo DOCUMENTO: " + documento));
		return seguradoDto;
	}
}
