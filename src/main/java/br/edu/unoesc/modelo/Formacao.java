package br.edu.unoesc.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "FORMACAO")
public class Formacao extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "nome_curso", nullable = false, unique = true)
	private String nomeCurso;
	
	@Column(name = "nivel_formacao", nullable = false)
	private String nivelFormacao;
	
	@Column(name = "data_conclusao", nullable = false)
	private String dataConclusao;
	
	@Column(name = "instituicao_ensino", nullable = false)
	private String instituicaoEnsino;
	
	@ManyToOne
	@JoinColumn(name = "time_id")
	private Time time;
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public String getNivelFormacao() {
		return nivelFormacao;
	}
	
	public void setNivelFormacao(String nivelFormacao) {
		this.nivelFormacao = nivelFormacao;
	}
	
	public String getDataConclusao() {
		return dataConclusao;
	}
	
	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
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
	 