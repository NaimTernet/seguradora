package com.qintess.seguradora.cotador.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "SEGURADO_EMAIL")
public class SeguradoEmail extends AbstractEntity {
	private String email;

}
