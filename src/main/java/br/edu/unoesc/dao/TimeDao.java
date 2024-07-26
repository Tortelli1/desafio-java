package br.edu.unoesc.dao;

import java.util.List;

import br.edu.unoesc.modelo.Time;

public interface TimeDao {

	void save(Time time);
	
	void update(Time time);
	
	void delete(Long id);
	
	Time findById(Long id);
	
	List<Time> findAll();
}
