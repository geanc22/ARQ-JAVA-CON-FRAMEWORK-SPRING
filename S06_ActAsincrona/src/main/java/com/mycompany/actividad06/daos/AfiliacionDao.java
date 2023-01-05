package com.mycompany.actividad06.daos;


import com.mycompany.actividad06.entidades.Conductor;
import java.util.List;

public interface AfiliacionDao {
    
    public void registro(Conductor conductor);
    public List<Conductor> findAll();
    
}
