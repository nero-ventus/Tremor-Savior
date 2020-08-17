/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.dao;

import com.tremor.modelo.datos_vitales;

/**
 *
 * @author devil
 */
public interface Idatos_vitalesdao {
    int altadatos_vitales(datos_vitales a,String correo);
    
    datos_vitales traedatos_vitales(String correo);
    
    int actualizadatos_vitales(datos_vitales a,String correo);
    
    int borradatos_vitales(String correo);
}
