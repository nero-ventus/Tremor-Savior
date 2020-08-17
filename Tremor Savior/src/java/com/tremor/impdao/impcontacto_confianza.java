/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.impdao;

import com.tremor.bd.conexion_base;
import com.tremor.dao.Icontacto;
import com.tremor.dao.Icontacto_confianzadao;
import com.tremor.modelo.contacto;
import com.tremor.modelo.contacto_confianza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class impcontacto_confianza implements Icontacto_confianzadao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String registro1="call sp_contacto_c(0,?,?,?,?,0)";
    private final String registro2="call sp_contacto_cs(0,?,?,?,0)";
    private final String llamarvarios="call sp_get_contactosc(?)";
    private final String actualiza1="call sp_contacto_c(1,?,?,?,?,?)";
    private final String elimina="call sp_delete_contacto(?)";
    private final String eliminacontacc="call sp_delete_contacto_c(?,?)";
    @Override
    public int altacontacto_confianza(contacto_confianza a, String correo, ArrayList<contacto> lista_contacto) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registro1);
            sta.setString(1, correo);
            sta.setString(2, a.getNombre());
            sta.setString(3, a.getApellido_p());
            sta.setString(4, a.getApellido_m());
            resul=sta.executeQuery();
            if(resul.next()){
                for(int i=0;i<lista_contacto.size();i++){
                    sta=conex.prepareCall(registro2);
                    sta.setString(1, lista_contacto.get(i).getContacto());
                    sta.setInt(2, lista_contacto.get(i).getId_tipoc());
                    sta.setInt(3, resul.getInt(1));
                    sta.executeQuery();
                }
                valida=1;
                conex.close();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return valida;
    }

    @Override
    public contacto_confianza traecontacto_confianza(int id_contac, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizacontacto_confianza(contacto_confianza a, String correo, ArrayList<contacto> lista_contacto) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(actualiza1);
            sta.setString(1, correo);
            sta.setString(2, a.getNombre());
            sta.setString(3, a.getApellido_p());
            sta.setString(4, a.getApellido_m());
            sta.setInt(5, a.getId_contactoc());
            resul=sta.executeQuery();
            if(resul.next()){
                Icontacto controla_contac=new impcontacto();
                ArrayList<contacto> lista_borra=controla_contac.traeContactos(a.getId_contactoc());
                for (int i=0;i<lista_borra.size();i++) {
                    sta=conex.prepareCall(elimina);
                    sta.setInt(1, lista_borra.get(i).getId_contacto());
                    sta.executeQuery();
                }
                for (int i=0;i<lista_contacto.size();i++) {
                    sta=conex.prepareCall(registro2);
                    sta.setString(1, lista_contacto.get(i).getContacto());
                    sta.setInt(2, lista_contacto.get(i).getId_tipoc());
                    sta.setInt(3, a.getId_contactoc());
                    sta.executeQuery();
                }
                valida=1;
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return valida;
    }

    @Override
    public int borracontacto_confianza(int id_contac, String correo) {
        int realizado=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            Icontacto controla_contac=new impcontacto();
            ArrayList<contacto> lista_borra=controla_contac.traeContactos(id_contac);
            for (int i=0;i<lista_borra.size();i++) {
                sta=conex.prepareCall(elimina);
                sta.setInt(1, lista_borra.get(i).getId_contacto());
                sta.executeQuery();
            }
            sta=conex.prepareCall(eliminacontacc);
            sta.setInt(1, id_contac);
            sta.setString(2, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                realizado=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return realizado;
    }

    @Override
    public ArrayList<contacto_confianza> traecontactos(String correo) {
        ArrayList<contacto_confianza> lista=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamarvarios);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new contacto_confianza(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
}