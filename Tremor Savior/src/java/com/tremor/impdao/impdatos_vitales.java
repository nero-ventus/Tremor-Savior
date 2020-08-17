/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.impdao;

import com.tremor.bd.conexion_base;
import com.tremor.dao.Idatos_vitalesdao;
import com.tremor.modelo.datos_vitales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author devil
 */
public class impdatos_vitales implements Idatos_vitalesdao{
    private final String trae_uno="call sp_get_dv(?)";
    private Connection conex=null;
    private PreparedStatement sta=null;
    private ResultSet resul=null;
    @Override
    public int altadatos_vitales(datos_vitales a, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public datos_vitales traedatos_vitales(String correo) {
        datos_vitales datosv=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_uno);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                datosv=new datos_vitales(resul.getInt(1), resul.getInt(2), resul.getString(3), resul.getString(4));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return datosv;
    }

    @Override
    public int actualizadatos_vitales(datos_vitales a, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borradatos_vitales(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
