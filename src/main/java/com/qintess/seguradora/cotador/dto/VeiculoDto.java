package com.qintess.seguradora.cotador.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.qintess.seguradora.cotador.model.Segurado;
import com.qintess.seguradora.cotador.model.Veiculo;

import lombok.Data;

@Data
public class VeiculoDto implements Serializable {
	private static final long serialVersionUID = -4472103289625604764L;

	private Long id;
	private String marca;
	private String modelo;
	private String placa;
	private String cor;
	private String chassi;
	private String renavan;
	private String tipo;
	private Long codigoFipe;
	private Long valorFipe;

	public Veiculo toVeiculo(Segurado segurado) {
		Veiculo veiculo = new Veiculo();
		BeanUtils.copyProperties(this, veiculo);
		veiculo.setSegurado(segurado);
		return veiculo;
	}

	public static VeiculoDto toVeiculoDto(Veiculo veiculo) {
		VeiculoDto veiculoDto = new VeiculoDto();
		BeanUtils.copyProperties(veiculo, veiculoDto);
		return veiculoDto;
	}
}
