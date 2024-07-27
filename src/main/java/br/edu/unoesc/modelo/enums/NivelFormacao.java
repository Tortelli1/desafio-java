package br.edu.unoesc.modelo.enums;

public enum NivelFormacao {

	ENSINO_MEDIO("Ensino médio"),
	TECNICO("Técnico"),
	BACHARELADO("Bacharel"),
	ESPECIALIZADO("Especialização"),
	MESTRADO("Mestrado"),
	DOUTORADO("Doutorado"),
	OUTRAS_FORMACOES("Outras formações");
	
		
	private String formacao;
		
		private NivelFormacao(String formacao) {
			this.formacao = formacao;
		}
		
		public String getNivelFormacao() {
			return formacao;
		}
}
