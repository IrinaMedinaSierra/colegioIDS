package com.ceatformacion.colegio.controller;


import com.ceatformacion.colegio.modell.Alumnos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Iterator;

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
        alumnos.asignarIdAlumno();
        /*incrementar id...falta*/
        listaAlumnos.add(alumnos);
        model.addAttribute("alumnos", listaAlumnos);
        //verificar que esta leyendo bien los datos.......
        System.out.println(alumnos);

        return "redirect:listado"; // Redirige después del POST
    }
    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        model.addAttribute("alumnos", listaAlumnos);
        return "listado";
    }

    @GetMapping("/eliminar/{idAlumno}")
    public String eliminarAlumno(Model model, @PathVariable("idAlumno") int idAlumno) {
        listaAlumnos.removeIf(alumno -> alumno.getIdAlumno() == idAlumno);
        return "redirect:/listado";
    }
    @GetMapping("/editar/{idAlumno}")
    public String mostrarFormularioEditar(@PathVariable("idAlumno") int idAlumno, Model model) {
        Alumnos alumnosE = null;
        Iterator<Alumnos> iterator = listaAlumnos.iterator();
        while (iterator.hasNext()) {
            Alumnos a = iterator.next();
            if (a.getIdAlumno() == idAlumno) {
                alumnosE = a;
                break;
            }
        }
        if (listaAlumnos != null) {
            model.addAttribute("alumno", alumnosE);
            return "editarAlumno";
        } else {
            return "redirect:/listado"; // si no lo encuentra, vuelve al listado
        }
    }

    @PostMapping("/actualizar")
    public String actualizarEmpleado(@ModelAttribute Alumnos alumnoActualizado) {
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if (listaAlumnos.get(i).getIdAlumno() == alumnoActualizado.getIdAlumno()) {
                listaAlumnos.set(i, alumnoActualizado);
                break;
            }
        }
        return "redirect:/listado";
    }




}
