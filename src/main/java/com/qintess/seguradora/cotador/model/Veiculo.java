package com.qintess.seguradora.cotador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="VEICULO")
public class Veiculo extends AbstractEntity {
	private String marca;
	private String modelo;
	private String placa;
	private String cor;
	private String chassi;
	private String renavan;
	private String tipo;
	private Long codigoFipe;
	private Long valorFipe;
}
