package com.myproyects.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproyects.demo.daos.AfiliacionRepository;
import com.myproyects.demo.entidades.Afiliacion;



@Service
public class AfiliacionServiceImpl implements AfiliacionService{
	@Autowired
	private AfiliacionRepository dao;

	@Override
	public void grabar(Afiliacion afiliacion) {
		dao.save(afiliacion);
	}

	@Override
	public void eliminar(String id) {
		dao.deleteById(id);
	}

	@Override

	public Afiliacion buscar(String id) {return dao.findById(id).orElse(null);
	}

	@Override

	public List<Afiliacion> listar() {
		return (List<Afiliacion>)dao.findAll();
	}

}

