package br.edu.unoesc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.unoesc.dao.FormacaoDao;
import br.edu.unoesc.modelo.Formacao;

@Service
@Transactional(readOnly = false)
public class FormacaoServiceImpl implements FormacaoService{

	@Autowired
	private FormacaoDao dao;
	
	@Override
	public void salvar(Formacao formacao) {
		dao.save(formacao);
	}

	@Override
	public void editar(Formacao formacao) {
		dao.update(formacao);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Formacao buscarPorId(Long id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Formacao> buscarTodos() {
	
		return dao.findAll();
	}

}
