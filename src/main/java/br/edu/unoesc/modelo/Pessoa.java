package br.edu.unoesc.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PESSOA")
public class Pessoa extends AbstractEntity{
	
	@Column(nullable = false)
	private String nome;
	
	@Column(name = "cpf_formatado", nullable = false, unique = true)
	private String cpfFormatado;	

	@Column(name = "data_nascimento" , nullable = false)
	private LocalDate dataNascimento;
	
	@Column(nullable = false)
	private String genero;
	
	@Column(name = "numero_telefone", nullable = false)
	private String numeroTelefone;
	
	@Column(name = "endereco_email", nullable = false, unique = true)
	private String enderecoEmail;
	
	@OneToOne
	private Time time;
	
	@OneToOne
	private Formacao formacao;

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
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	public String getEnderecoEmail() {
		return enderecoEmail;
	}
	
	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	
}
