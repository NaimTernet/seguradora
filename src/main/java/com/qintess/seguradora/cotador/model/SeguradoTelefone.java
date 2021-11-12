package com.qintess.seguradora.cotador.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="SEGURADO_TELEFONE")
public class SeguradoTelefone extends AbstractEntity {
	private String telefone;
}
