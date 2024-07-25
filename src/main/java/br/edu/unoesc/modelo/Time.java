package br.edu.unoesc.modelo;

@SuppressWarnings("serial")
public class Time extends AbstractEntity{

	private String nome;
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
