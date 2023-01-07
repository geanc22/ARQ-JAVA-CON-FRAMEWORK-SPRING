package com.myproyects.demo.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import com.myproyects.demo.entidades.Afiliacion;
import com.myproyects.demo.service.AfiliacionService;
	
@Controller
@SessionAttributes("afiliacion")
public class AfiliacionController{
        @Autowired
    private AfiliacionService servicio;
        
    /*LISTA DE CONDUCTORES*/
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Afiliados");
        model.addAttribute("conductores", servicio.listar());
        return "listarView";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listarFull(Model model) {
        model.addAttribute("titulo", "Listado de Afiliados");
        model.addAttribute("conductores", servicio.listar());
        return "listarView";
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public String buscar(@PathVariable String dni, Model model) {
        model.addAttribute("titulo", "Listado de Afiliados");
        model.addAttribute("conductores", servicio.buscar(dni));
        return "buscarView";
    }
        
    /*AFILIAR O REGISTRAR CONDUCTORES*/
     @RequestMapping(value = "/form")
        public String registrar(Map<String, Object> model) {

            Afiliacion conductor = new Afiliacion();
            model.put("conductor", conductor);
            model.put("titulo", "Datos Personales");
            return "afiliacionView";
        }

    
     /*GUARDAR DE CONDUCTORES*/
     @RequestMapping(value = "/form", method = RequestMethod.POST)
     public String guardar(@Valid Afiliacion conductor, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
           model.addAttribute("titulo", "Formulario de Afiliado");
           return "afiliacionView";
      }
        servicio.grabar(conductor);
         status.setComplete();
         return "redirect:listar";
      }
     
     /*EDITAR  CONDUCTORES*/
     @RequestMapping(value="/form/{id}")
     public String editar(@PathVariable(value="id") String id, Map<String, Object> model) {

     Afiliacion conductor = null;

         if (id!=null && id.length()>0) {
             conductor = servicio.buscar(id);
         } else {
             return "redirect:/listar";
         }
       model.put("conductor", conductor);
       model.put("titulo", "Editar Afiliado");
       return "afiliacionView";
    }

     /*ELIMINAR DE CONDUCTORES*/
     @RequestMapping(value="/eliminar/{id}")
     public String eliminar(@PathVariable(value="id") String id) {

         if (id!=null && id.length()>0) {
             servicio.eliminar(id);
         }
        return "redirect:/listar";
      }
    
        
}