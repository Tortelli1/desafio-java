package br.edu.unoesc.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuario extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	private String user;
	
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
