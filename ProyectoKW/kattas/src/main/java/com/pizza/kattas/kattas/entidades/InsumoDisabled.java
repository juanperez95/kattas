package com.pizza.kattas.kattas.entidades;

import java.sql.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insumos_disabled")
public class InsumoDisabled {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String categoria;
    private String estado;
    private int cantidad;
    private Date fecha_entrada;
    private Date fecha_vence;

    public InsumoDisabled() {
    }

    public InsumoDisabled(String nombre, String categoria, String estado, int cantidad, Date fecha_entrada,
            Date fecha_vence) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.estado = estado;
        this.cantidad = cantidad;
        this.fecha_entrada = fecha_entrada;
        this.fecha_vence = fecha_vence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_vence() {
        return fecha_vence;
    }

    public void setFecha_vence(Date fecha_vence) {
        this.fecha_vence = fecha_vence;
    }


}
