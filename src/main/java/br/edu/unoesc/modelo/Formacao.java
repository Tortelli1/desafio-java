package br.edu.unoesc.modelo;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "FORMACAO")
public class Formacao extends AbstractEntity{
	
	@Column(name = "nome_curso", nullable = false, unique = true)
	private String nomeCurso;
	
	@Column(name = "nivel_curso", nullable = false)
	private String nivelCurso;
	
	@Column(name = "data_conclusao", nullable = false)
	private String dataConclusão;
	
	@Column(name = "instituicao_ensino", nullable = false)
	private String instituicaoEnsino;
	
	@ManyToOne
	private Time time;
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public String getNivelCurso() {
		return nivelCurso;
	}
	
	public void setNivelCurso(String nivelCurso) {
		this.nivelCurso = nivelCurso;
	}
	
	public String getDataConclusão() {
		return dataConclusão;
	}
	
	public void setDataConclusão(String dataConclusão) {
		this.dataConclusão = dataConclusão;
	}
	
	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}
	
	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
}
	 