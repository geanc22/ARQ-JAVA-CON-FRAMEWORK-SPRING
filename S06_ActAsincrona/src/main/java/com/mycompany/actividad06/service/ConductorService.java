package com.mycompany.actividad06.service;


import com.mycompany.actividad06.entidades.Conductor;
import java.util.List;

public interface ConductorService {
    public void grabar(Conductor conductor);
    public List<Conductor> baja();
}
