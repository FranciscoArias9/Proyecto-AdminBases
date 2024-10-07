package com.proyecto.backend.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rutina;
    
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "instructor", nullable = false)
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "maquina", nullable = false)
    private Maquina maquina;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    private int horas;
    private String nombre;

    // Getters y Setters

    public int getId_rutina() {
        return id_rutina;
    }

    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
