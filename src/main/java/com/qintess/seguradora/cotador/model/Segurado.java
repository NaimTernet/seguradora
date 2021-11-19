package com.qintess.seguradora.cotador.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.collect.Lists;

import lombok.Data;

@Entity
@Data
@Table(name = "SEGURADO")
public class Segurado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "documento", nullable = false)
	private Long documento;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SeguradoTelefone> telefones =Lists.newArrayList();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SeguradoEmail> emails =Lists.newArrayList();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SeguradoEndereco> enderecos =Lists.newArrayList();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Veiculo> veiculos =Lists.newArrayList();
	
	public void addTelefone(SeguradoTelefone seguradoTelefone) {
		telefones.add(seguradoTelefone);
		seguradoTelefone.setSegurado(this);
	}
	
}
