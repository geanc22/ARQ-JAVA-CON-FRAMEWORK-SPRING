package com.myproyects.demo.daos;

import java.util.List;

import com.myproyects.demo.entidades.Conductor;


public interface ConductorDao {

	public List<Conductor> findAll();

	public void registrar(Conductor conductor);

	public Conductor findOne(Integer dni);

	public void delete(Integer dni);
}
