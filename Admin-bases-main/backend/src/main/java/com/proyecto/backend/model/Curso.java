package com.proyecto.backend.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_curso;

    private String descripcion;
    private String nombre;
    private String horario;

    // Constructor vacío (necesario para JPA)
    public Curso() {
    }

    // Constructor sin ID
    public Curso(String descripcion, String nombre, String horario) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.horario = horario;
    }

    // Getters y Setters
    public int getId_curso() {
        return id_curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id_curso=" + id_curso +
                ", descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}



/* 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_curso;

    private String descripcion;
    private String nombre;
    private String horario;

    // Constructor
    public Curso(int id_curso, String descripcion, String nombre, String horario) {
        this.id_curso = id_curso;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.horario = horario;
    }

    // Constructor vacío (necesario para JPA)
    public Curso() {
    }

    // Getters y Setters
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


   


} */
