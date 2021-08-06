package com.argmoviles.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.argmoviles.backend.models.dao.INetoDao;
import com.argmoviles.backend.models.entity.Neto;

@Service
public class NetoServiceImpl implements INetoService {

	@Autowired
	INetoDao netoDao;

	@Override
	public List<Neto> findAll() {
		return (List<Neto>) netoDao.findAll();
	}

	
	
	@Override
	@Transactional(readOnly = true)
	public Neto findById(Long id) {
		return netoDao.findById(id).orElse(null);
	}

	@Override
	public Neto save(Neto neto) {
		return netoDao.save(neto);
	}

	@Override
	public void delete(Long id) {
		netoDao.deleteById(id);
	}
	
}
