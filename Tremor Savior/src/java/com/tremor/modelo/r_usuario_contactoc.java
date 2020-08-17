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
public class r_usuario_contactoc {
    private int id_r_usua_conc;
    private int id_contactoc;
    private int id_usuario;

    public r_usuario_contactoc(int id_r_usua_conc, int id_contactoc, int id_usuario) {
        this.id_r_usua_conc = id_r_usua_conc;
        this.id_contactoc = id_contactoc;
        this.id_usuario = id_usuario;
    }

    public int getId_r_usua_conc() {
        return id_r_usua_conc;
    }

    public void setId_r_usua_conc(int id_r_usua_conc) {
        this.id_r_usua_conc = id_r_usua_conc;
    }

    public int getId_contactoc() {
        return id_contactoc;
    }

    public void setId_contactoc(int id_contactoc) {
        this.id_contactoc = id_contactoc;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "r_usuario_contactoc{" + "id_r_usua_conc=" + id_r_usua_conc + ", id_contactoc=" + id_contactoc + ", id_usuario=" + id_usuario + '}';
    }
    
}