package com.qintess.seguradora.cotador.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "SEGURADO_ENDERECO")
public class SeguradoEndereco implements Serializable {

	private static final long serialVersionUID = -5590742915980302768L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;

	@ManyToOne(fetch = FetchType.LAZY)
	private Segurado segurado;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeguradoEndereco other = (SeguradoEndereco) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
