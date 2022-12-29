package com.mycompany.actividad04.service;


import com.mycompany.actividad04.entidades.Conductor;
import java.util.List;

public interface ConductorService {
    public void grabar(Conductor conductor);
    public List<Conductor> baja();
}
