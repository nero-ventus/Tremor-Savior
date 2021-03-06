/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.controlador;

import com.tremor.dao.Iusuariodao;
import com.tremor.impdao.impusuariodao;
import com.tremor.modelo.dato_inicio;
import com.tremor.modelo.usuario;
import com.tremor.seguridad.encriptador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author devil
 */
@WebServlet(name = "elimina_usua", urlPatterns = {"/elimina_usua"})
public class elimina_usua extends HttpServlet {

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
            out.println("<title>Servlet elimina_usua</title>");            
            out.println("<script>\n" +
"            function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('TremorSaviorLogIn.html');\n" +
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
                    int valida=controlador.borrausuario(correo);
                    if(valida==1){
                        sesion.invalidate();
                        out.println("<script>alert('Usuario Eliminado')</script>");
                        out.println("<script>presiona1();</script>");
                    }
                    else{
                        out.println("<script>alert('Error en la eliminacion')</script>");
                        out.println("<script>presiona2();</script>");
                    }
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
