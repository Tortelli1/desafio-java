package br.edu.unoesc.modelo;

import java.time.LocalDate;

import br.edu.unoesc.modelo.enums.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nome;
	
	@Column(name = "cpf_formatado", nullable = false)
	private String cpfFormatado;	

	@Column(name = "data_nascimento" , nullable = false)
	private LocalDate dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Genero genero;
	
	@Column(name = "numero_telefone", nullable = false)
	private String numeroTelefone;
	
	@Column(name = "endereco_email", nullable = false)
	private String enderecoEmail;
	
	@ManyToOne
	@JoinColumn(name = "time_id")
	private Time time;
	
	@ManyToOne
	@JoinColumn(name = "formacao_id")
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
	
	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
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
