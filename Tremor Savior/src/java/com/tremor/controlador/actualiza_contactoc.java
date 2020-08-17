/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.controlador;

import com.tremor.dao.Icontacto_confianzadao;
import com.tremor.dao.Iusuariodao;
import com.tremor.impdao.impcontacto_confianza;
import com.tremor.impdao.impusuariodao;
import com.tremor.modelo.contacto;
import com.tremor.modelo.contacto_confianza;
import com.tremor.modelo.dato_inicio;
import com.tremor.modelo.usuario;
import com.tremor.seguridad.encriptador;
import com.tremor.seguridad.validaCaracteres;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "actualiza_contactoc", urlPatterns = {"/actualiza_contactoc"})
public class actualiza_contactoc extends HttpServlet {

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
            out.println("<title>Servlet actualiza_contactoc</title>");            
            out.println("<script>\n" +
"            function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('TremorSaviorContactosdeConfianza.jsp');\n" +
"                },0);\n" +
"            }\n" +
"            function presiona2(){\n" +
"                setTimeout(function (){\n" +
"                    window.history.back();\n" +
"                },0);\n" +
"            }\n" +
"            function presiona3(){\n" +
"                setTimeout(function (){\n" +
"                    window.history.back();\n" +
"                },0);\n" +
"            }\n" +
"        </script>");
            out.println("</head>");
            out.println("<body>");
            Iusuariodao controlador=new impusuariodao();
            usuario user=null;
            encriptador encripta=new encriptador();
            HttpSession sesion=request.getSession();
            try{
                String correo=encripta.desencriptar((String)(sesion.getAttribute("correo")));
                String contra=encripta.desencriptar((String)(sesion.getAttribute("contra")));
                dato_inicio cuenta=new dato_inicio(correo, contra);
                user=controlador.traeusuario(cuenta);
                if(!(user==null)){
                    Icontacto_confianzadao controla_contacc=new impcontacto_confianza();
                    contacto_confianza contacc=null;
                    ArrayList<contacto> lista_contac=new ArrayList<>();
                    try{
                        String unnombre=request.getParameter("nombre");
                        String unapellido_p=request.getParameter("apellido_p");
                        String unapellido_m=request.getParameter("apellido_m");
                        String uncorreoc=request.getParameter("correo");
                        int idcontacc=Integer.parseInt(request.getParameter("idcontacc"));
                        int telefono=0;
                        try{
                            telefono=Integer.parseInt(request.getParameter("telefono"));
                        }
                        catch(Exception e) {
                            System.out.println(e.getMessage());
                            telefono=0;
                        }
                        validaCaracteres validac=new validaCaracteres();
                        int validacarac=validac.validaRegistro_contactoc(unnombre, unapellido_p, unapellido_m, uncorreoc);
                        if(validacarac==0){
                            String nombre=ESAPI.encoder().encodeForHTML(unnombre);
                            String apellido_p=ESAPI.encoder().encodeForHTML(unapellido_p);
                            String apellido_m=ESAPI.encoder().encodeForHTML(unapellido_m);
                            String correoc=ESAPI.encoder().encodeForHTML(uncorreoc);
                            contacc=new contacto_confianza(idcontacc, nombre, apellido_p, apellido_m);
                            if(!(request.getParameter("telefono").equals("") && request.getParameter("correo").equals(""))){
                                if(!(request.getParameter("telefono").equals(""))){
                                    lista_contac.add(new contacto(0, Integer.toString(telefono), 2));
                                }
                                if(!(request.getParameter("correo").equals(""))){
                                    lista_contac.add(new contacto(0, correoc, 1));
                                }
                                int realizado=controla_contacc.actualizacontacto_confianza(contacc, correo, lista_contac);
                                if(realizado==1){
                                    out.println("<script>alert('Actualizacion realizada');</script>");
                                    out.print("<Script>presiona1();</Script>");
                                }
                                else{
                                    out.println("<script>alert('Error en el registro');</script>");
                                    out.print("<Script>presiona2();</Script>");
                                }
                            }
                            else{
                                out.println("<script>alert('Llene un telefono o correo');</script>");
                                out.print("<Script>presiona2();</Script>");
                            }
                       }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        out.println("<script>alert('Datos erroneos');</script>");
                        out.print("<Script>presiona2();</Script>");
                    }
                }
                else{
                    out.println("<script>alert('Inicia sesion primero');</script>");
                    out.print("<Script>presiona2();</Script>");
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
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
