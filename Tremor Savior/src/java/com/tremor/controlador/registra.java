/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.controlador;

import com.tremor.dao.Iusuariodao;
import com.tremor.impdao.impusuariodao;
import com.tremor.modelo.dato_inicio;
import com.tremor.modelo.datos_vitales;
import com.tremor.modelo.usuario;
import com.tremor.seguridad.encriptador;
import com.tremor.seguridad.validaCaracteres;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "registra", urlPatterns = {"/registra"})
public class registra extends HttpServlet {

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
            out.println("<script>\n" +
"            function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('Home.jsp');\n" +
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
            out.println("<head>");
            out.println("<title>Servlet registra</title>");            
            out.println("</head>");
            out.println("<body>");
            int longitud=0;
            try {
                String[] listal={request.getParameter("nombre"),request.getParameter("apellido_p"),request.getParameter("apellido_m"),request.getParameter("correo"),request.getParameter("contra"),request.getParameter("fechan"),request.getParameter("nss"),request.getParameter("csecreta"),request.getParameter("tsangre")};
                for(int i=0;i<listal.length;i++) {
                    if(listal[i].length()>40){
                        longitud=1;
                        break;
                    }
                }
            }
            catch (Exception e) {
                out.println("<script>alert('Varifica que los datos hallan sido bien introducidos, Intentalo de Nuevo');<alert>");
                out.println("<script>presiona2();</script>");
            }
            if(longitud==0){
                Iusuariodao usuario=new impusuariodao();
                usuario user=null;
                dato_inicio cuenta=null;
                datos_vitales dv=null;
                int correctos=0;
                try{
                    int ano=Integer.parseInt(request.getParameter("fechan").substring(0,4));
                    int mes=Integer.parseInt(request.getParameter("fechan").substring(5,7));
                    int dia=Integer.parseInt(request.getParameter("fechan").substring(8));
                    int tiposangre=Integer.parseInt(request.getParameter("tsangre"));
                    Date naci=new Date((ano-1900),(mes-1),dia);
                    user=new usuario(0, request.getParameter("nombre"), request.getParameter("apellido_p"), request.getParameter("apellido_m"), naci, request.getParameter("correo"),0);
                    cuenta=new dato_inicio(request.getParameter("correo"), request.getParameter("contra"));
                    dv=new datos_vitales(0, tiposangre, request.getParameter("nss"), request.getParameter("csecreta"));
                    validaCaracteres validadorC=new validaCaracteres();
                    correctos=validadorC.validaRagistro(user, cuenta, dv);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                if(correctos==0){
                    try{
                        int ano=Integer.parseInt(request.getParameter("fechan").substring(0,4));
                        int mes=Integer.parseInt(request.getParameter("fechan").substring(5,7));
                        int dia=Integer.parseInt(request.getParameter("fechan").substring(8));
                        int tiposangre=Integer.parseInt(request.getParameter("tsangre"));
                        Date naci=new Date((ano-1900),(mes-1),dia);
                        String nombre=ESAPI.encoder().encodeForHTML(request.getParameter("nombre"));
                        String apellido_p=ESAPI.encoder().encodeForHTML(request.getParameter("apellido_p"));
                        String apellido_m=ESAPI.encoder().encodeForHTML(request.getParameter("apellido_m"));
                        String correo=ESAPI.encoder().encodeForHTML(request.getParameter("correo"));
                        String contra=ESAPI.encoder().encodeForHTML(request.getParameter("contra"));
                        String nss=ESAPI.encoder().encodeForHTML(request.getParameter("nss"));
                        String csecreta=ESAPI.encoder().encodeForHTML(request.getParameter("csecreta"));
                        user=new usuario(0, nombre, apellido_p, apellido_m, naci, correo,0);
                        cuenta=new dato_inicio(correo, contra);
                        dv=new datos_vitales(0, tiposangre, nss, csecreta);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    int contrasIguales=0;
                    if(request.getParameter("contra").equals(request.getParameter("ccontra"))) {
                        contrasIguales=1;
                    }
                    if(contrasIguales==1){
                        int registro=usuario.altausuario(user, cuenta, dv);
                        if(registro==1){
                            HttpSession sesion=request.getSession();
                            encriptador encripta=new encriptador();
                            sesion.setAttribute("correo", encripta.encriptar(cuenta.getCorreo()));
                            sesion.setAttribute("contra", encripta.encriptar(cuenta.getContra()));
                            out.println("<script>alert('Usuario Registrado,En breve se le enviara a la pagina de inicio')</script>");
                            out.println("<script>presiona1();</script>");
                        }
                        else{
                            out.println("El correo ya esta en uso");
                            out.println("<script>presiona2();</script>");
                        }
                    }
                    else{
                        out.println("Las contraseñas son diferentes");
                        out.println("<script>presiona2();</script>");
                    }
                }
                else{
                    out.println("Verifica que utilizaste los caracteres validos");
                    out.println("<script>presiona2();</script>");
                }
            }
            else{
                out.println("Verifica el tamaño de tus datos");
                out.println("<script>presiona2();</script>");
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
