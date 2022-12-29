
package com.mycompany.actividad04.pruebas;


import com.mycompany.actividad04.entidades.Conductor;
import com.mycompany.actividad04.service.ConductorService;
import com.mycompany.actividad04.service.ConductorServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Prueba01 {
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(com.mycompany.actividad04.AppConfig.class);
        ConductorService servicio = (ConductorServiceImpl)applicationContext.getBean("conductorServiceImpl");
        
        Conductor c01 = new Conductor(1234567, "Juan", "Alberto", "Santino", "22/03/1999", "Jr. Lampa 23", 967233423, "santinoalbert@gmail.com");
        Conductor c02 = new Conductor(7682312, "Elvis", "Canahuiri", "Hinojosa", "12/01/2000", "Av. Angamos 234", 978231224, "elviChau@gmail.com");
        
       
        servicio.grabar(c01);
        servicio.grabar(c02);
        
        for(Conductor c: servicio.baja()){
            System.out.println(c);
        }
    }
}
