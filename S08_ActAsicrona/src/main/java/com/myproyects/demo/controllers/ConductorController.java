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
import org.springframework.web.bind.support.SessionStatus;


import com.myproyects.demo.daos.ConductorDao;
import com.myproyects.demo.entidades.Conductor;
	
@Controller
public class ConductorController{
        @Autowired
    private ConductorDao dao;
        
    /*LISTA DE CONDUCTORES*/
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de conductores");
        model.addAttribute("conductores", dao.findAll());
        return "listarView";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listarFull(Model model) {
        model.addAttribute("titulo", "Listado de conductores");
        model.addAttribute("conductores", dao.findAll());
        return "listarView";
    }
        
    /*AFILIAR O REGISTRAR CONDUCTORES*/
     @RequestMapping(value = "/form")
        public String registrar(Map<String, Object> model) {

            Conductor conductor = new Conductor();
            model.put("conductor", conductor);
            model.put("titulo", "Datos Personales");
            return "afiliacionView";
        }

    
     /*GUARDAR DE CONDUCTORES*/
     @RequestMapping(value = "/form", method = RequestMethod.POST)
     public String guardar(@Valid Conductor conductor, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
           model.addAttribute("titulo", "Formulario de Conductor");
           return "afiliacionView";
      }
         dao.registrar(conductor);
         status.setComplete();
         return "redirect:listar";
      }
     
     /*EDITAR  CONDUCTORES*/
     @RequestMapping(value="/form/{dni}")
     public String editar(@PathVariable(value="dni") Integer dni, Map<String, Object> model) {

     Conductor conductor = null;

      if(dni > 0) {
      conductor = dao.findOne(dni);
       } else {
        return "redirect:/listar";
       }
       model.put("conductor", conductor);
       model.put("titulo", "Editar Conductor");
       return "afiliacionView";
    }

     /*ELIMINAR DE CONDUCTORES*/
     @RequestMapping(value="/eliminar/{dni}")
     public String eliminar(@PathVariable(value="dni") Integer dni) {

        if(dni > 0) {
         dao.delete(dni);
        }
        return "redirect:/listar";
      }
    
        
}