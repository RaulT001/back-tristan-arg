package com.argmoviles.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.argmoviles.backend.models.dao.ILlamarDao;
import com.argmoviles.backend.models.entity.Llamar;

@Service
public class LlamarServiceImpl implements ILlamarService {
	
	@Autowired
	private ILlamarDao llamarDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Llamar> findAll() {
		return (List<Llamar>) llamarDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Llamar findById(Long id) {
		return llamarDao.findById(id).orElse(null);
	}

	@Override
	public Llamar save(Llamar llamar) {
		return llamarDao.save(llamar);
	}

	@Override
	public void delete(Long id) {
		llamarDao.deleteById(id);
	}

	@Override
	public Llamar update(Llamar llamar) {
		return llamarDao.save(llamar);
	}
	
}
