package com.mycompany.actividad04.daos;


import com.mycompany.actividad04.entidades.Conductor;
import java.util.List;

public interface AfiliacionDao {
    
    public void registro(Conductor conductor);
    public List<Conductor> findAll();
    
}
