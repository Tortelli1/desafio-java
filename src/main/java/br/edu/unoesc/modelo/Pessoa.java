package br.edu.unoesc.modelo;

@SuppressWarnings("serial")
public class Pessoa extends AbstractEntity{

	private String nome;
	private String cpfFormatado;
	private int dataNascimento;
	private String genero;
	private Short numeroTelefone;
	private String enderecoEmail;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpfFormatado() {
		return cpfFormatado;
	}
	public void setCpfFormatado(String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
	}
	public int getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Short getNumeroTelefone() {
		return numeroTelefone;
	}
	public void setNumeroTelefone(Short numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	public String getEnderecoEmail() {
		return enderecoEmail;
	}
	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}
	
	
}
