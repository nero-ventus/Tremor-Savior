/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.dao;

import com.tremor.modelo.contacto;
import com.tremor.modelo.contacto_confianza;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public interface Icontacto_confianzadao {
    int altacontacto_confianza(contacto_confianza a,String correo,ArrayList<contacto> lista_contacto);
    
    contacto_confianza traecontacto_confianza(int id_contac,String correo);
    
    int actualizacontacto_confianza(contacto_confianza a,String correo,ArrayList<contacto> lista_contacto);
    
    int borracontacto_confianza(int id_contac,String correo);
    
    ArrayList<contacto_confianza> traecontactos(String correo);
}