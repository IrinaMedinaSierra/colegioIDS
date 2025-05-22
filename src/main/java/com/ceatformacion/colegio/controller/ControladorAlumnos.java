package com.ceatformacion.colegio.controller;


import com.ceatformacion.colegio.modell.Alumnos;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ControladorAlumnos {


    //metodo que llama la vista altaAlumno desde el Controlador
    @GetMapping("/altaAlumno") //como se llama la vista en la url
    public String llamarAlta(Model model) {
        //creo un objeto tipo Alumno.....-> Model
       model.addAttribute("alumno", new Alumnos());
        return "altaAlumno"; //debe devolver el nombre del html que quieres mostrar
    }

    //Lista de objetos de tipo alumno la declaras fuera de los metodos para poder acceder a esos datos
    ArrayList<Alumnos> listaAlumnos=new ArrayList<>();
    @PostMapping("/listado")
    public String mostrarListado(Model model, @ModelAttribute Alumnos  alumnos) {
        alumnos.setIdAlumno();
        /*incrementar id...falta*/
        listaAlumnos.add(alumnos);
        model.addAttribute("alumnos", listaAlumnos);
        //verificar que esta leyendo bien los datos.......
        System.out.println(alumnos);

        return "listado";
    }

    @GetMapping("/eliminar/{idAlumno}")
    public String eliminarAlumno(Model model, @PathVariable("idAlumno") int idAlumno) {
        listaAlumnos.removeIf(alumno -> alumno.getIdAlumno() == idAlumno);
        return "listado";
    }


}
