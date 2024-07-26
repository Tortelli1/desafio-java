package br.edu.unoesc.service;

import java.util.List;

import br.edu.unoesc.modelo.Pessoa;

public interface PessoaService {

	void salvar (Pessoa pessoa);
	
	void editar (Pessoa pessoa);
	
	void excluir (Long id);
	
	Pessoa buscarPorId(Long id);
	
	List<Pessoa> buscarTodos();
}
