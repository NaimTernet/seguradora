package com.qintess.seguradora.cotador.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.qintess.seguradora.cotador.model.Segurado;
import com.qintess.seguradora.cotador.model.SeguradoTelefone;

import lombok.Data;

@Data
public class SeguradoTelefoneDto implements Serializable {
	private static final long serialVersionUID = -4277729467676837603L;
	private Long id;
	private String telefone;

	public SeguradoTelefone toSeguradoTelefone(Segurado segurado) {
		SeguradoTelefone seguradoTelefone = new SeguradoTelefone();
		BeanUtils.copyProperties(this, seguradoTelefone);
		seguradoTelefone.setSegurado(segurado);
		return seguradoTelefone;
	}

	public static SeguradoTelefoneDto toSeguradoTelefoneDto(SeguradoTelefone seguradoTelefone) {
		SeguradoTelefoneDto seguradoTelefoneDto = new SeguradoTelefoneDto();
		BeanUtils.copyProperties(seguradoTelefone, seguradoTelefoneDto);
		return seguradoTelefoneDto;
	}
}
