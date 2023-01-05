
package com.mycompany.actividad06.pruebas;


import com.mycompany.actividad06.entidades.Conductor;
import com.mycompany.actividad06.service.ConductorService;
import com.mycompany.actividad06.service.ConductorServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Prueba01 {
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(com.mycompany.actividad06.AppConfig.class);
        ConductorService servicio = (ConductorServiceImpl)applicationContext.getBean("conductorServiceImpl");
        
        Conductor c01 = new Conductor(6782344, "Tania", "Alvarez", "Osores", "22/07/1995", "Jr. Ramis 12", 967233423, "tanAlva@gmail.com");
        Conductor c02 = new Conductor(7682312, "Fredy", "Origuela", "Auispe", "15/02/2002", "Av. Sol 234", 978231224, "estufredy@gmail.com");
        
       
        servicio.grabar(c01);
        servicio.grabar(c02);
        
        for(Conductor c: servicio.baja()){
            System.out.println(c);
        }
    }
}
