/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.seguridad;

import com.tremor.modelo.dato_inicio;
import com.tremor.modelo.datos_vitales;
import com.tremor.modelo.usuario;

/**
 *
 * @author devil
 */
public class validaCaracteres {
    public int validaRagistro(usuario a, dato_inicio b, datos_vitales c){
        int validado=0;
        try{
            String[] alfabeticos={a.getNombre(),a.getApellido_p(),a.getApellido_m()};
            String[] alfanumericos={b.getContra(),c.getCsecreta()};
            for(int i=0;i<alfabeticos.length;i++) {
                for (int j=0;j<alfabeticos[i].length();j++) {
                    if((alfabeticos[i].charAt(j)<65 || 90<alfabeticos[i].charAt(j)) && (alfabeticos[i].charAt(j)<97 || 122<alfabeticos[i].charAt(j)) && !(alfabeticos[i].charAt(j)==32)){
                        validado=1;
                        break;
                    }
                }
                if(validado==1){
                    break;
                }
            }
            if(validado==0){
                for(int i=0;i<alfanumericos.length;i++) {
                    for (int j=0;j<alfanumericos[i].length();j++) {
                        if((alfanumericos[i].charAt(j)<48 || 57<alfanumericos[i].charAt(j)) && (alfanumericos[i].charAt(j)<65 || 90<alfanumericos[i].charAt(j)) && (alfanumericos[i].charAt(j)<97 || 122<alfanumericos[i].charAt(j)) && !(alfanumericos[i].charAt(j)==32)){
                            validado=1;
                            break;
                        }
                    }
                    if(validado==1){
                        break;
                    }
                }
                if(validado==0){
                    for (int i=0;i<c.getNss().length();i++) {
                        if(c.getNss().charAt(i)<48 || 57<c.getNss().charAt(i)) {
                            validado=1;
                            break;
                        }
                    }
                    if(validado==0){
                        for (int i=0;i<b.getCorreo().length();i++) {
                            if((b.getCorreo().charAt(i)<48 || 57<b.getCorreo().charAt(i)) && (b.getCorreo().charAt(i)<64 || 90<b.getCorreo().charAt(i)) && (b.getCorreo().charAt(i)<97 || 122<b.getCorreo().charAt(i)) && !(b.getCorreo().charAt(i)==32 || b.getCorreo().charAt(i)==95 || b.getCorreo().charAt(i)==126 || b.getCorreo().charAt(i)==46)){
                                validado=1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return validado;
    }
    public int validadInicio(dato_inicio b){
        int validado=0;
        try{
            String[] alfanumericos={b.getContra()};
            for(int i=0;i<alfanumericos.length;i++) {
                for (int j=0;j<alfanumericos[i].length();j++) {
                    if((alfanumericos[i].charAt(j)<48 || 57<alfanumericos[i].charAt(j)) && (alfanumericos[i].charAt(j)<65 || 90<alfanumericos[i].charAt(j)) && (alfanumericos[i].charAt(j)<97 || 122<alfanumericos[i].charAt(j)) && !(alfanumericos[i].charAt(j)==32)){
                        validado=1;
                        break;
                    }
                }
                if(validado==1){
                    break;
                }
            }
            if(validado==0){
                for (int i=0;i<b.getCorreo().length();i++) {
                    if((b.getCorreo().charAt(i)<48 || 57<b.getCorreo().charAt(i)) && (b.getCorreo().charAt(i)<64 || 90<b.getCorreo().charAt(i)) && (b.getCorreo().charAt(i)<97 || 122<b.getCorreo().charAt(i)) && !(b.getCorreo().charAt(i)==32 || b.getCorreo().charAt(i)==95 || b.getCorreo().charAt(i)==126 || b.getCorreo().charAt(i)==46)){
                        validado=1;
                        break;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            validado=1;
        }
        return validado;
    }
    public int validaRegistro_contactoc(String unnombre,String unapellido_p,String unapellido_m,String correo){
        int valida=0;
        try{
            String[] alfabeticos={unnombre,unapellido_p,unapellido_m};
            for(int i=0;i<alfabeticos.length;i++){
                for (int j=0;j<alfabeticos[i].length();j++) {
                    if((alfabeticos[i].charAt(j)<65 || 90<alfabeticos[i].charAt(j)) && (alfabeticos[i].charAt(j)<97 || 122<alfabeticos[i].charAt(j)) && !(alfabeticos[i].charAt(j)==32)){
                        valida=1;
                        break;
                    }
                }
                if(valida==1){
                    break;
                }
            }
            if(valida==0){
                for (int i=0;i<correo.length();i++) {
                    if((correo.charAt(i)<48 || 57<correo.charAt(i)) && (correo.charAt(i)<64 || 90<correo.charAt(i)) && (correo.charAt(i)<97 || 122<correo.charAt(i)) && !(correo.charAt(i)==32 || correo.charAt(i)==95 || correo.charAt(i)==126 || correo.charAt(i)==46)){
                        valida=1;
                        break;
                    }
                }
            }
        }
        catch(Exception e){ 
            System.out.println(e.getMessage());
        }
        return valida;
    }
}