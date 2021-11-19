package com.qintess.seguradora.cotador.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.qintess.seguradora.cotador.model.Segurado;

import lombok.Data;

@Data
public class SeguradoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private Long documento;
	private List<SeguradoTelefoneDto> telefones = Lists.newArrayList();
	private List<SeguradoEmailDto> emails = Lists.newArrayList();
	private List<SeguradoEnderecoDto> enderecos = Lists.newArrayList();
	private List<VeiculoDto> veiculos = Lists.newArrayList();

	public Segurado toSegurado() {
		Segurado segurado = new Segurado();
		BeanUtils.copyProperties(this, segurado);
		// lambida para converter um seguradoTelefoneDto para um seguradoTelefone.
		// para cada seguradoTelefoneDto sera gerado um novo seguradoTelefone
		segurado.setTelefones(
				telefones.stream().map(seguradoTelefoneDto -> seguradoTelefoneDto.toSeguradoTelefone(segurado))
						.collect(Collectors.toList()));

		segurado.setEmails(emails.stream().map(seguradoEmailDto -> seguradoEmailDto.toSeguradoEmail(segurado))
				.collect(Collectors.toList()));

		segurado.setEnderecos(
				enderecos.stream().map(seguradoEnderecoDto -> seguradoEnderecoDto.toSeguradoEndereco(segurado))
						.collect(Collectors.toList()));

		segurado.setVeiculos(veiculos.stream().map(veiculoDto -> veiculoDto.toVeiculo(segurado))
				.collect(Collectors.toList()));

		return segurado;
	}
}
