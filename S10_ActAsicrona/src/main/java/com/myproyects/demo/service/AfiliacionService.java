package com.myproyects.demo.service;

import java.util.List;

import com.myproyects.demo.entidades.Afiliacion;



public interface AfiliacionService {
	 public List<Afiliacion> listar();

	    public void grabar(Afiliacion afiliacion);

	    public Afiliacion buscar(String id);

	    public void eliminar(String id);
}
