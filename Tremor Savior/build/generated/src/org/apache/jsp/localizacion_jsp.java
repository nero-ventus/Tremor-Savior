package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class localizacion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <style>\n");
      out.write("      /* Set the size of the div element that contains the map */\n");
      out.write("      #map {\n");
      out.write("        height: 400px;  /* The height is 400 pixels */\n");
      out.write("        width: 100%;  /* The width is the width of the web page */\n");
      out.write("       }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        h3>My Google Maps Demo</h3>\n");
      out.write("    <!--The div element for the map -->\n");
      out.write("    <div id=\"map\"></div>\n");
      out.write("    <script>\n");
      out.write("// Initialize and add the map\n");
      out.write("function initMap() {\n");
      out.write("  // The location of Uluru\n");
      out.write("  var uluru = {lat: -25.344, lng: 131.036};\n");
      out.write("  // The map, centered at Uluru\n");
      out.write("  var map = new google.maps.Map(\n");
      out.write("      document.getElementById('map'), {zoom: 4, center: uluru});\n");
      out.write("  // The marker, positioned at Uluru\n");
      out.write("  var marker = new google.maps.Marker({position: uluru, map: map});\n");
      out.write("}\n");
      out.write("    </script>\n");
      out.write("    <script async defer\n");
      out.write("    src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCFPKaKfsROx1V0gzxcSnSScF5CqkJc4qY&callback=initMap\">\n");
      out.write("    </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
