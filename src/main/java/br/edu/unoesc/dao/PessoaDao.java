package br.edu.unoesc.dao;

import java.util.List;

import br.edu.unoesc.modelo.Pessoa;

public interface PessoaDao {

	void save(Pessoa pessoa);
	
	void update(Pessoa pessoa);
	
	void delete(Long id);
	
	Pessoa findById(Long id);
	
	List<Pessoa> findAll();
}
