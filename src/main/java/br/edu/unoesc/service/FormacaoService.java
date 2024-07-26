package br.edu.unoesc.service;

import java.util.List;

import br.edu.unoesc.modelo.Formacao;

public interface FormacaoService {

	void salvar (Formacao formacao);
	
	void editar (Formacao formacao);
	
	void excluir (Long id);
	
	Formacao buscarPorId(Long id);
	 
	List<Formacao> buscarTodos();
}
