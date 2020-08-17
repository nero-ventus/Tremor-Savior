package com.tremor.seguridad;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author devil
 */
public class encriptador {
    private final String key="0000110100000111";
    private final String VI="0000011100001101";
    public String encriptar(String texto_plano){
        String resultado=null;
        try{
            IvParameterSpec iv=new IvParameterSpec(VI.getBytes("UTF-8"));
            SecretKeySpec skspec=new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cifrador=Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cifrador.init(Cipher.ENCRYPT_MODE,skspec,iv);
            byte[] encriptado=cifrador.doFinal(texto_plano.getBytes());
            resultado=Base64.encodeBase64String(encriptado);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    public String desencriptar(String encriptado){
        String texto_plano=null;
        try {
            IvParameterSpec iv=new IvParameterSpec(VI.getBytes("UTF-8"));
            SecretKeySpec skspec=new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skspec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encriptado));
            texto_plano=new String(original);
        }
        catch (Exception e) {
            System.out.println(e.getMessage()+"___"+e.getLocalizedMessage());
        }
        return texto_plano;
    }
}