/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.controlador;

import com.tremor.dao.Icontacto;
import com.tremor.dao.Icontacto_confianzadao;
import com.tremor.dao.Idatos_vitalesdao;
import com.tremor.dao.Iusuariodao;
import com.tremor.impdao.impcontacto;
import com.tremor.impdao.impcontacto_confianza;
import com.tremor.impdao.impdatos_vitales;
import com.tremor.impdao.impusuariodao;
import com.tremor.modelo.contacto;
import com.tremor.modelo.contacto_confianza;
import com.tremor.modelo.dato_inicio;
import com.tremor.modelo.datos_vitales;
import com.tremor.modelo.usuario;
import com.tremor.seguridad.encriptador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author devil
 */
@WebServlet(name = "estoy_bien", urlPatterns = {"/estoy_bien"})
public class estoy_bien extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet estoy_bien</title>");
            out.println("<script>function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('Home.jsp');\n" +
"                },0);\n" +
"            }\n" +
"            function presiona2(){\n" +
"                setTimeout(function (){\n" +
"                    window.history.back();\n" +
"                },0);\n" +
"            }</script>");
            out.println("</head>");
            out.println("<body>");
            HttpSession datos_sesion = request.getSession();
            encriptador encripta = new encriptador();
            usuario usua = null;
            Iusuariodao controlador = new impusuariodao();
            try {
                String correo = encripta.desencriptar((String) (datos_sesion.getAttribute("correo")));
                String contra = encripta.desencriptar((String) (datos_sesion.getAttribute("contra")));
                dato_inicio cuenta = new dato_inicio(correo, contra);
                usua = controlador.traeusuario(cuenta);
                if (!(usua == null)) {
                    Idatos_vitalesdao controla_dv=new impdatos_vitales();
                    datos_vitales dv=controla_dv.traedatos_vitales(correo);
                    String lati=request.getParameter("lati");
                    String longi=request.getParameter("longi");
                    Icontacto_confianzadao controla_contacc=new impcontacto_confianza();
                    ArrayList<contacto_confianza> listac_contacc=controla_contacc.traecontactos(correo);
                    for(int i=0;i<listac_contacc.size();i++){
                        Icontacto controla_contac=new impcontacto();
                        ArrayList<contacto> lista_contac=controla_contac.traeContactos(listac_contacc.get(i).getId_contactoc());
                        for(int j=0;j<lista_contac.size();j++){
                            if(lista_contac.get(j).getId_tipoc()==1){
                                String from="trynitycorpsbussines@gmail.com";
                                contra="trinitycorps18";
                                String to=ESAPI.encoder().decodeForHTML(lista_contac.get(j).getContacto());
                                String tsangre="";
                                if(dv.getTipo_sangre()==1){
                                    tsangre="A+";
                                }
                                if(dv.getTipo_sangre()==2){
                                    tsangre="A-";
                                }
                                if(dv.getTipo_sangre()==3){
                                    tsangre="B+";
                                }
                                if(dv.getTipo_sangre()==4){
                                    tsangre="B-";
                                }
                                if(dv.getTipo_sangre()==5){
                                    tsangre="AB+";
                                }
                                if(dv.getTipo_sangre()==6){
                                    tsangre="AB-";
                                }
                                if(dv.getTipo_sangre()==7){
                                    tsangre="O+";
                                }
                                if(dv.getTipo_sangre()==8){
                                    tsangre="O-";
                                }
                                String mensaje=usua.getNombre()+" le informa que esta bien, su clave secreta es '"+dv.getCsecreta()+"' \n Por si no lo sabe su tipo de sangre es "+tsangre+" y su NSS es "+dv.getNss()+" \n Su localizacion es la siguiente: https://maps.google.com/?q="+lati+","+longi;
                                String host="smtp.gmail.com";
                                String subject="Localizacion de "+usua.getNombre();
                                boolean sessionDebug=false;

                                Properties proper=System.getProperties();
                                proper.put("mail.smtp.starttls.enable", "true");
                                proper.put("mail.smtp.host", host);
                                proper.put("mail.smtp.port", "587");
                                proper.put("mail.smtp.auth", "true");
                                proper.put("mail.smtp.starttls.required", "true");

                                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                                Session sesion=Session.getDefaultInstance(proper,null);
                                sesion.setDebug(sessionDebug);
                                Message msj=new MimeMessage(sesion);
                                msj.setFrom(new InternetAddress(from));
                                InternetAddress[] direccion={new InternetAddress(to)};
                                msj.setRecipients(Message.RecipientType.TO, direccion);
                                msj.setSubject(subject);
                                msj.setSentDate(new Date());
                                msj.setText(mensaje);

                                Transport transporte=sesion.getTransport("smtp");
                                transporte.connect(host,from,contra);
                                transporte.sendMessage(msj, msj.getAllRecipients());
                                transporte.close();
                            }
                        }
                    }
                    out.println("<script>alert('Mensaje enviado');</script>");
                    out.println("<script>presiona1();</script>");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
