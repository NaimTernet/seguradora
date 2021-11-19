package com.qintess.seguradora.cotador.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.qintess.seguradora.cotador.model.Segurado;
import com.qintess.seguradora.cotador.model.SeguradoTelefone;
import com.qintess.seguradora.cotador.model.Veiculo;

import lombok.Data;

@Entity
@Data
@Table(name = "VEICULO")
public class VeiculoDto implements Serializable {

	private static final long serialVersionUID = -4472103289625604764L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@ManyToOne(fetch = FetchType.LAZY)
	private SeguradoDto segurado;
	
	public Veiculo toVeiculo(Segurado segurado) {
		Veiculo veiculo = new Veiculo();
		BeanUtils.copyProperties(this, veiculo);
		veiculo.setSegurado(segurado);
		return veiculo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculoDto other = (VeiculoDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
