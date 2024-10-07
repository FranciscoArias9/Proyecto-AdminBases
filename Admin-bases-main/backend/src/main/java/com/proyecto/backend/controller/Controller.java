package com.proyecto.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.backend.model.Curso;
import com.proyecto.backend.repository.CursoRepository;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hola, mundo!";
    }

    @GetMapping("/cursos")
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll(); // Devuelve la lista de cursos desde la base de datos
    }

    @PostMapping("/cursos")
public Curso agregarCurso(@RequestBody Curso curso) {
    Curso cursoGuardado = cursoRepository.save(curso);
    System.out.println("Curso guardado: " + cursoGuardado); // Esto mostrará el curso guardado en la consola
    return cursoGuardado;
}

    

    
}
