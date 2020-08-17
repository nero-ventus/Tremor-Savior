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
public class r_contactoc_contacto {
    private int id_r_con_conc;
    private int id_contactoc;
    private int id_contacto;

    public r_contactoc_contacto(int id_r_con_conc, int id_contactoc, int id_contacto) {
        this.id_r_con_conc = id_r_con_conc;
        this.id_contactoc = id_contactoc;
        this.id_contacto = id_contacto;
    }

    public int getId_r_con_conc() {
        return id_r_con_conc;
    }

    public void setId_r_con_conc(int id_r_con_conc) {
        this.id_r_con_conc = id_r_con_conc;
    }

    public int getId_contactoc() {
        return id_contactoc;
    }

    public void setId_contactoc(int id_contactoc) {
        this.id_contactoc = id_contactoc;
    }

    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    @Override
    public String toString() {
        return "r_contactoc_contacto{" + "id_r_con_conc=" + id_r_con_conc + ", id_contactoc=" + id_contactoc + ", id_contacto=" + id_contacto + '}';
    }
    
}