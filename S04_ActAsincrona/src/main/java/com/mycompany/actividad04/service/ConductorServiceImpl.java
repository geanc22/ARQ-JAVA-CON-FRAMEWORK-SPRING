
package com.mycompany.actividad04.service;

import com.mycompany.actividad04.daos.AfiliacionDao;
import com.mycompany.actividad04.entidades.Conductor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConductorServiceImpl implements ConductorService{
    @Autowired
    AfiliacionDao dao;
    
    @Override
    public void grabar(Conductor conductor) {
        dao.registro(conductor);
    }

    @Override
    public List<Conductor> baja() {
       return dao.findAll();
    }
    
}
