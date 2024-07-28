package br.edu.unoesc.modelo.enums;

public enum Genero {

	MASCULINO("Masculino"),
	FEMININO("Feminino"),
	OUTROS("Outros");
	
	private String descricao;

	Genero(String descricao) {
		this.descricao = descricao;
	}

		public String getDescricao() {
			return descricao;
		}
	
}
