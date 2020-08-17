/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tremor.seguridad;

import com.tremor.modelo.dato_inicio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author devil
 */
@WebServlet(name = "seguridad_inicio", urlPatterns = {"/seguridad_inicio"})
public class seguridad_inicio extends HttpServlet {

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
            out.println("<title>Servlet seguridad_inicio</title>");            
            out.println("</head>");
            out.println("<body>");
            validaCaracteres validaC=new validaCaracteres();
            try {
                dato_inicio cuenta=new dato_inicio(request.getParameter("correo"), request.getParameter("contra"));
                int validacarac=validaC.validadInicio(cuenta);
                if(validacarac==0){
                    encriptador encripta=new encriptador();
                    String correo=ESAPI.encoder().encodeForHTML(request.getParameter("correo"));
                    String contra=ESAPI.encoder().encodeForHTML(request.getParameter("contra"));
                    String encripcorreo=encripta.encriptar(correo);
                    String encripcontra=encripta.encriptar(contra);
                    request.setAttribute("correo", encripcorreo);
                    request.setAttribute("contra", encripcontra);
                    RequestDispatcher rd = request.getRequestDispatcher("inicia");
                    rd.forward(request,response);
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
