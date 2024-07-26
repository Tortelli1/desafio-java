package br.edu.unoesc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.unoesc.dao.TimeDao;
import br.edu.unoesc.modelo.Time;

@Service
@Transactional(readOnly = false)
public class TimeServiceImpl implements TimeService{

	@Autowired
	private TimeDao dao;
	
	@Override
	public void salvar(Time time) {
		dao.save(time);
	}

	@Override
	public void editar(Time time) {
		dao.update(time);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Time buscarPorId(Long id) {

		return dao.findById(id);
	}

	@Override
	public List<Time> buscarTodos() {
		
		return dao.findAll();
	}
	

}
