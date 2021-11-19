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
@Table(name = "SEGURADO_EMAIL")
public class SeguradoEmail implements Serializable {

	private static final long serialVersionUID = -788106018878195198L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;

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
		SeguradoEmail other = (SeguradoEmail) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
