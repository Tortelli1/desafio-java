package br.edu.unoesc.modelo;

@SuppressWarnings("serial")
public class Formacao extends AbstractEntity{
	
	private String nomeCurso;
	private String nivelCurso;
	private String dataConclusão;
	private String instituicaoEnsino;
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

	
}
	 