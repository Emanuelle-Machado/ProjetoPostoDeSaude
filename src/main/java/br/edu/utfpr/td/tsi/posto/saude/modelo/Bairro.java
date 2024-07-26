package br.edu.utfpr.td.tsi.posto.saude.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bairro", schema = "postodesaude")
public class Bairro {
	
	@Id
	@Column(name = "idbairro")
	private String id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	public Bairro() {
	}
	public Bairro(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	

}

