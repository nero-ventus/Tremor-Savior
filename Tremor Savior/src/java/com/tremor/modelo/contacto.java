/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.modelo;

/**
 *
 * @author Alumno
 */
public class contacto {
    private int id_contacto;
    private String contacto;
    private  int id_tipoc;

    public contacto(int id_contacto, String contacto, int id_tipoc) {
        this.id_contacto = id_contacto;
        this.contacto = contacto;
        this.id_tipoc = id_tipoc;
    }

    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getId_tipoc() {
        return id_tipoc;
    }

    public void setId_tipoc(int id_tipoc) {
        this.id_tipoc = id_tipoc;
    }

    @Override
    public String toString() {
        return "contacto{" + "id_contacto=" + id_contacto + ", contacto=" + contacto + ", id_tipoc=" + id_tipoc + '}';
    }
    
}