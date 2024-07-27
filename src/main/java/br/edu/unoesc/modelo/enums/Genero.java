package br.edu.unoesc.modelo.enums;

public enum Genero {

	MASCULINO,
	FEMININO,
	OUTROS;
	
	private String genero;

		public String getGenero() {
			return genero;
		}
	
		public void setGenero(String genero) {
			this.genero = genero;
		}
	
}
