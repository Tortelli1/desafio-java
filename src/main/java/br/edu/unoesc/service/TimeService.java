package br.edu.unoesc.service;

import java.util.List;

import br.edu.unoesc.modelo.Time;

public interface TimeService {

	void salvar (Time time);
	
	void editar (Time time);
	
	void excluir (Long id);
	
	Time buscarPorId(Long id);
	
	List<Time> buscarTodos();
}
