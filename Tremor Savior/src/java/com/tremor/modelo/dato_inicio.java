package com.tremor.modelo;
public class dato_inicio {
    private String correo;
    private String contra;

    public dato_inicio(String correo, String contra) {
        this.correo = correo;
        this.contra = contra;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public String toString() {
        return "dato_inicio{" + "correo=" + correo + ", contra=" + contra + '}';
    }
    
}