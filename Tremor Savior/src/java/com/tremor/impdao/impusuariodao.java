/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.impdao;

import com.tremor.bd.conexion_base;
import com.tremor.dao.Icontacto_confianzadao;
import com.tremor.dao.Idatos_vitalesdao;
import com.tremor.dao.Iusuariodao;
import com.tremor.modelo.contacto_confianza;
import com.tremor.modelo.dato_inicio;
import com.tremor.modelo.datos_vitales;
import com.tremor.modelo.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public class impusuariodao implements Iusuariodao{
    private final String c_registro="call sp_usuario(0,?,?,?,?,?,?,?,?,?)";
    private final String c_getusuario="call sp_getusuario(?,?)";
    private final String c_actualiza="call sp_usuario(1,?,?,?,?,?,?,?,?,?)";
    private final String elidv="call sp_delete_dv(?)";
    private final String eliusua="call sp_delete_usua(?)";
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    @Override
    public int altausuario(usuario a, dato_inicio b, datos_vitales c) {
        conexion_base conecta=new conexion_base();
        conex=conecta.getConex();
        int valida=0;
        try{
            sta=conex.prepareCall(c_registro);
            sta.setString(1, a.getNombre());
            sta.setString(2, a.getApellido_p());
            sta.setString(3, a.getApellido_m());
            sta.setString(4, b.getCorreo());
            sta.setString(5, b.getContra());
            sta.setDate(6, a.getFecha_n());
            sta.setString(7, c.getNss());
            sta.setString(8, c.getCsecreta());
            sta.setInt(9, c.getTipo_sangre());
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println("El error es: "+e.getMessage());
        }
        return valida;
    }

    @Override
    public usuario traeusuario(dato_inicio cuenta) {
        conexion_base conecta=new conexion_base();
        conex=conecta.getConex();
        usuario usua=null;
        try{
            sta=conex.prepareCall(c_getusuario);
            sta.setString(1, cuenta.getCorreo());
            sta.setString(2, cuenta.getContra());
            resul=sta.executeQuery();
            if(resul.next()){
                usua=new usuario(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getDate(5), resul.getString(6), resul.getInt(7));
            }
        }
        catch(Exception e){
            System.out.println("El error es: "+e.getMessage()+e.getCause());
        }
        return usua;
    }

    @Override
    public int actualizausuario(usuario a,dato_inicio b,datos_vitales c) {
        int realizado=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(c_actualiza);
            sta.setString(1, a.getNombre());
            sta.setString(2, a.getApellido_p());
            sta.setString(3, a.getApellido_m());
            sta.setString(4, b.getCorreo());
            sta.setString(5, b.getContra());
            sta.setDate(6, a.getFecha_n());
            sta.setString(7, c.getNss());
            sta.setString(8, c.getCsecreta());
            sta.setInt(9, c.getTipo_sangre());
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
    public int borrausuario(String correo) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            Icontacto_confianzadao controla_contacc=new impcontacto_confianza();
            ArrayList<contacto_confianza> lista_contacc=controla_contacc.traecontactos(correo);
            for (int i=0;i<lista_contacc.size();i++){
                controla_contacc.borracontacto_confianza(lista_contacc.get(i).getId_contactoc(), correo);
            }
            Idatos_vitalesdao controladv=new impdatos_vitales();
            datos_vitales dvs=controladv.traedatos_vitales(correo);
            sta=conex.prepareCall(eliusua);
            sta.setString(1, correo);
            sta.executeQuery();
            sta=conex.prepareCall(elidv);
            sta.setInt(1, dvs.getId_dv());
            sta.executeQuery();
            valida=1;
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return valida;
    }
}
