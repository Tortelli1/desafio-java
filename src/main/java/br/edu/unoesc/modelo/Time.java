package br.edu.unoesc.modelo;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "TIME")
public class Time extends AbstractEntity{

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String setor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	
}
