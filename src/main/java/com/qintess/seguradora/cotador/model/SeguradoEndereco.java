package com.qintess.seguradora.cotador.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "SEGURADO_ENDERECO")
public class SeguradoEndereco extends AbstractEntity {
	private String endereco;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
}
