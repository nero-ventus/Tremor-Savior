package com.tremor.modelo;
public class datos_vitales {
    private int id_dv;
    private int tipo_sangre;
    private String nss;
    private String csecreta;

    public datos_vitales(int id_dv, int tipo_sangre, String nss, String csecreta) {
        this.id_dv = id_dv;
        this.tipo_sangre = tipo_sangre;
        this.nss = nss;
        this.csecreta = csecreta;
    }

    public int getId_dv() {
        return id_dv;
    }

    public void setId_dv(int id_dv) {
        this.id_dv = id_dv;
    }

    public int getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(int tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getCsecreta() {
        return csecreta;
    }

    public void setCsecreta(String csecreta) {
        this.csecreta = csecreta;
    }

    @Override
    public String toString() {
        return "datos_vitales{" + "id_dv=" + id_dv + ", tipo_sangre=" + tipo_sangre + ", nss=" + nss + ", csecreta=" + csecreta + '}';
    }
    
}