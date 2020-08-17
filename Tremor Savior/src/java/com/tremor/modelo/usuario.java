package com.tremor.modelo;

import java.sql.Date;

public class usuario {
    private int id_usuario;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private Date fecha_n;
    private String correo;
    private int id_dv;

    public usuario(int id_usuario, String nombre, String apellido_p, String apellido_m, Date fecha_n, String correo, int id_dv) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.fecha_n = fecha_n;
        this.correo = correo;
        this.id_dv = id_dv;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public Date getFecha_n() {
        return fecha_n;
    }

    public void setFecha_n(Date fecha_n) {
        this.fecha_n = fecha_n;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_dv() {
        return id_dv;
    }

    public void setId_dv(int id_dv) {
        this.id_dv = id_dv;
    }

    @Override
    public String toString() {
        return "usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido_p=" + apellido_p + ", apellido_m=" + apellido_m + ", fecha_n=" + fecha_n + ", correo=" + correo + ", id_dv=" + id_dv + '}';
    }
    
    
}