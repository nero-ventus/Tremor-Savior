package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class form_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form>\n");
      out.write("            <input type=\"text\" name=\"nombre\" id=\"nombre\" required placeholder=\"Nombre(s)\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"apellido_p\" id=\"apellido_p\" required placeholder=\"Apellido Paterno\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"apellido_m\" id=\"apellido_m\" required placeholder=\"Apellido Materno\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"correo\" id=\"correo\" required placeholder=\"Correo electronico\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"password\" name=\"contra\" id=\"contra\" required placeholder=\"Contraseña\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"password\" name=\"ccontra\" id=\"ccontra\" required placeholder=\"Confirmar contraseña\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"date\" name=\"fechan\" id=\"fechan\">\n");
      out.write("            <select name=\"semestre\" id=\"semestre\">\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione un semestre</option>\n");
      out.write("                <option value=\"1\">1°</option>\n");
      out.write("                <option value=\"2\">2°</option>\n");
      out.write("                <option value=\"3\">3°</option>\n");
      out.write("                <option value=\"4\">4°</option>\n");
      out.write("                <option value=\"5\">5°</option>\n");
      out.write("                <option value=\"6\">6°</option>\n");
      out.write("            </select>\n");
      out.write("            <select name=\"turno\" id=\"turno\">\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione un turno</option>\n");
      out.write("                <option value=\"1\">Matutino</option>\n");
      out.write("                <option value=\"2\">Vespertino</option>\n");
      out.write("            </select>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
