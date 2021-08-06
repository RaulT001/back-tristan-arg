package com.argmoviles.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.argmoviles.backend.models.dao.IVendedorDao;
import com.argmoviles.backend.models.entity.Vendedor;

@Service
public class VendedorServiceImpl implements IVendedorService {
	
	@Autowired
	private IVendedorDao vendedorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> findAll() {
		return (List<Vendedor>) vendedorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Vendedor findById(Long id) {
		return vendedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Vendedor save(Vendedor vendedor) {
		return vendedorDao.save(vendedor);
	}

	@Override
	public void delete(Long id) {
		vendedorDao.deleteById(id);
		
	}

}
