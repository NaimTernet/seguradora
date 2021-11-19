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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SEGURADO_TELEFONE")
public class SeguradoTelefone implements Serializable {

	private static final long serialVersionUID = -4277729467676837603L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String telefone;
	@ManyToOne(fetch = FetchType.LAZY)
	private Segurado segurado;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeguradoTelefone other = (SeguradoTelefone) obj;
		return Objects.equals(id, other.id);
	}
	

}
