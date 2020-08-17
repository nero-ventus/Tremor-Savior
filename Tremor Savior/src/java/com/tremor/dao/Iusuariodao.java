package com.tremor.dao;

import com.tremor.modelo.dato_inicio;
import com.tremor.modelo.datos_vitales;
import com.tremor.modelo.usuario;

public interface Iusuariodao{
    int altausuario(usuario a,dato_inicio b,datos_vitales c);
    
    usuario traeusuario(dato_inicio cuenta);
    
    int actualizausuario(usuario a,dato_inicio b,datos_vitales c);
    
    int borrausuario(String correo);
}
