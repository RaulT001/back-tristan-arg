package com.argmoviles.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.argmoviles.backend.models.dao.IIngresoDao;
import com.argmoviles.backend.models.entity.Ingreso;

@Service
public class IngresoServiceImpl implements IIngresoService {
	
	@Autowired
	private IIngresoDao ingresoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Ingreso> findAll() {
		return (List<Ingreso>) ingresoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Ingreso findById(Long id) {
		return ingresoDao.findById(id).orElse(null);
	}

	@Override
	public Ingreso save(Ingreso ingreso) {
		return ingresoDao.save(ingreso);
	}

	@Override
	public void delete(Long id) {
		ingresoDao.deleteById(id);
	}

}
