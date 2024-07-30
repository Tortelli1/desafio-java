package br.edu.unoesc.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "TIME")
public class Time extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "nome_Time", nullable = false)
	private String nomeTime;
	
	@Column(nullable = false)
	private String setor;
	
	public String getNomeTime() {
		return nomeTime;
	}
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	
}
