package br.edu.unoesc.dao;

import java.util.List;

import br.edu.unoesc.modelo.Formacao;

public interface FormacaoDao {

	void save(Formacao formacao);
	
	void update(Formacao formacao);
	
	void delete(Long id);
	
	Formacao findById(Long id);
	
	List<Formacao> findAll();
}
