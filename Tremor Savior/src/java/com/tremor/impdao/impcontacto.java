/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.impdao;

import com.tremor.bd.conexion_base;
import com.tremor.dao.Icontacto;
import com.tremor.modelo.contacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class impcontacto implements Icontacto {
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String llamarvarios="call sp_get_contactos(?)";
    @Override
    public int altacontacto(Icontacto a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Icontacto traecontacto(int id_contacc, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizacontacto(Icontacto a, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borracontacto(int id_contacc, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<contacto> traeContactos(int id_contacc) {
        ArrayList<contacto> lista=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamarvarios);
            sta.setInt(1, id_contacc);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new contacto(resul.getInt(1), resul.getString(2), resul.getInt(3)));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
}