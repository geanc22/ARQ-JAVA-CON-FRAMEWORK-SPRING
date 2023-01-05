package com.mycompany.actividad06.daos.impl;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.mycompany.actividad06.daos.AfiliacionDao;
import com.mycompany.actividad06.entidades.Conductor;

@Component
public class AfiliacionDaoImpl implements AfiliacionDao{

    private List<Conductor> lista;

    public AfiliacionDaoImpl() {
        lista = new ArrayList<>();
    }

    @Override
    public void registro(Conductor conductor) {
        lista.add(conductor);
    }

    @Override
    public List<Conductor> findAll() {
        return lista;
    }
    
}
