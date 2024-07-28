package br.edu.unoesc.modelo.enums;

public enum NivelFormacao {

	ENSINO_MEDIO("Ensino médio"),
	TECNICO("Técnico"),
	BACHARELADO("Bacharel"),
	ESPECIALIZADO("Especialização"),
	MESTRADO("Mestrado"),
	DOUTORADO("Doutorado"),
	OUTRAS_FORMACOES("Outras formações");
	
	private String nivelFormacao;
	
	NivelFormacao(String nivelFormacao) {
		this.nivelFormacao = nivelFormacao;
	}

		public String getNivelFormacao() {
			return nivelFormacao;
		}
	
		public void setNivelFormacao(String nivelFormacao) {
			this.nivelFormacao = nivelFormacao;
		}
	
		
}
