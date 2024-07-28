package br.edu.unoesc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.modelo.Pessoa;

@Repository
public class PessoaDaoImpl extends AbstractDao<Pessoa, Long> implements PessoaDao{

	public List<Pessoa> findByNome(String nome) {

		return createQuery("select p from Pessoa p where p.nome like concat('%', ?1, '%') ", nome);
	}
}
