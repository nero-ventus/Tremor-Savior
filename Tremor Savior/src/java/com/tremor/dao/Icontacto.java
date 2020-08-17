/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.dao;

import com.tremor.modelo.contacto;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public interface Icontacto {
    int altacontacto(Icontacto a);
    
    Icontacto traecontacto(int id_contacc,String correo);
    
    int actualizacontacto(Icontacto a,String correo);
    
    int borracontacto(int id_contacc,String correo);
    
    ArrayList<contacto> traeContactos(int id_contacc);
}