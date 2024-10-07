package com.proyecto.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Maquina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_maquina;

    private String descripcion;
    private String estado;

    // Getters y Setters

    public int getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(int id_maquina) {
        this.id_maquina = id_maquina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
