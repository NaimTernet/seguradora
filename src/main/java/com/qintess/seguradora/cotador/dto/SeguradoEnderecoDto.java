package com.qintess.seguradora.cotador.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.qintess.seguradora.cotador.model.Segurado;
import com.qintess.seguradora.cotador.model.SeguradoEndereco;

import lombok.Data;

@Data
public class SeguradoEnderecoDto implements Serializable {
	private static final long serialVersionUID = -5590742915980302768L;
	private Long id;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	public SeguradoEndereco toSeguradoEndereco(Segurado segurado) {
		SeguradoEndereco seguradoEndereco = new SeguradoEndereco();
		BeanUtils.copyProperties(this, seguradoEndereco);
		seguradoEndereco.setSegurado(segurado);
		return seguradoEndereco;
	}
	
	public static SeguradoEnderecoDto toSeguradoEnderecoDto(SeguradoEndereco seguradoEndereco) {
		SeguradoEnderecoDto seguradoEnderecoDto = new SeguradoEnderecoDto();
		BeanUtils.copyProperties(seguradoEndereco, seguradoEnderecoDto);
		return seguradoEnderecoDto;
	}
	
	
}
