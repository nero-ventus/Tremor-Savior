/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.modelo;

/**
 *
 * @author devil
 */
public class contacto_confianza {
    private int id_contactoc;
    private String nombre;
    private String apellido_p;
    private String apellido_m;

    public contacto_confianza(int id_contactoc, String nombre, String apellido_p, String apellido_m) {
        this.id_contactoc = id_contactoc;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
    }

    public int getId_contactoc() {
        return id_contactoc;
    }

    public void setId_contactoc(int id_contactoc) {
        this.id_contactoc = id_contactoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    @Override
    public String toString() {
        return "contacto_confianza{" + "id_contactoc=" + id_contactoc + ", nombre=" + nombre + ", apellido_p=" + apellido_p + ", apellido_m=" + apellido_m + '}';
    }
    
}