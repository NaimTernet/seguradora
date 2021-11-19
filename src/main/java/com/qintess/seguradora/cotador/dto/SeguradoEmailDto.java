package com.qintess.seguradora.cotador.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.qintess.seguradora.cotador.model.Segurado;
import com.qintess.seguradora.cotador.model.SeguradoEmail;

import lombok.Data;

@Data
public class SeguradoEmailDto implements Serializable {
	private static final long serialVersionUID = -788106018878195198L;
	private Long id;
	private String email;

	public SeguradoEmail toSeguradoEmail(Segurado segurado) {
		SeguradoEmail seguradoEmail = new SeguradoEmail();
		BeanUtils.copyProperties(this, seguradoEmail);
		seguradoEmail.setSegurado(segurado);
		return seguradoEmail;
	}
}
