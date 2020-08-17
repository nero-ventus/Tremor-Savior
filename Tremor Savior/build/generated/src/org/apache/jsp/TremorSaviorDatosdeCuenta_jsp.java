package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tremor.impdao.impusuariodao;
import com.tremor.dao.Iusuariodao;
import com.tremor.modelo.usuario;
import com.tremor.modelo.dato_inicio;
import com.tremor.seguridad.encriptador;

public final class TremorSaviorDatosdeCuenta_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TremorSavior-Datos de Cuenta</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"imagenes/icono.png\" />\n");
      out.write("\n");
      out.write("        <link rel=\"shortcut icon\" href=\"favicon.ico\"> \n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <!--Import materialize.css-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/materialize.min.css\" media=\"screen,projection\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js\"></script>\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBCKiIqCdZGrVxx06LSbe7uG3zXOq1Cz5k&callback=initMap\" async defer></script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background: url(imagenes/fondoprinci.png) no-repeat center center fixed;\n");
      out.write("                -webkit-background-size: cover;\n");
      out.write("                -moz-background-size: cover;\n");
      out.write("                -o-background-size: cover;\n");
      out.write("                background-size: cover;\n");
      out.write("            } \n");
      out.write("            .input-field label {\n");
      out.write("                color: black!important;\n");
      out.write("            }\n");
      out.write("            /* label focus color */\n");
      out.write("            .input-field input[type=text]:focus + label {\n");
      out.write("                color: black! important;\n");
      out.write("            }\n");
      out.write("            /* label underline focus color */\n");
      out.write("            .input-field input[type=text]:focus {\n");
      out.write("                border-bottom: 1px solid green! important;\n");
      out.write("                box-shadow: 0 1px 0 0 green ! important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=text].valid {\n");
      out.write("                border-bottom: 1px solid #76ff03!important;\n");
      out.write("                box-shadow: 0 1px 0 0 #76ff03!important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=text].invalid {\n");
      out.write("                border-bottom: 1px solid red !important;\n");
      out.write("                box-shadow: 0 1px 0 0 red!important;\n");
      out.write("            }\n");
      out.write("            /* icon prefix focus color */\n");
      out.write("            .input-field .prefix.active {\n");
      out.write("                color: green;\n");
      out.write("            }\n");
      out.write("            .input-field input[type=password]:focus + label {\n");
      out.write("                color: black! important;\n");
      out.write("            }\n");
      out.write("            /* label underline focus color */\n");
      out.write("            .input-field input[type=password]:focus {\n");
      out.write("                border-bottom: 1px solid green! important;\n");
      out.write("                box-shadow: 0 1px 0 0 green ! important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=password].invalid {\n");
      out.write("                border-bottom: 1px solid red !important;\n");
      out.write("                box-shadow: 0 1px 0 0 red!important;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=password].valid {\n");
      out.write("                border-bottom: 1px solid #76ff03!important;\n");
      out.write("                box-shadow: 0 1px 0 0 #76ff03!important;\n");
      out.write("            }\n");
      out.write("            .input-field input[type=date]:focus + label {\n");
      out.write("                color: black! important;\n");
      out.write("            }\n");
      out.write("            /* label underline focus color */\n");
      out.write("            .input-field input[type=date]:focus {\n");
      out.write("                border-bottom: 1px solid green! important;\n");
      out.write("                box-shadow: 0 1px 0 0 green ! important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=date].invalid {\n");
      out.write("                border-bottom: 1px solid red !important;\n");
      out.write("                box-shadow: 0 1px 0 0 red!important;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=date].valid {\n");
      out.write("                border-bottom: 1px solid #76ff03!important;\n");
      out.write("                box-shadow: 0 1px 0 0 #76ff03!important;\n");
      out.write("            }\n");
      out.write("            ul.dropdown-content.select-dropdown li span {\n");
      out.write("                color: green; /* no need for !important :) */\n");
      out.write("            } \n");
      out.write("            nav{\n");
      out.write("                position: fixed;\n");
      out.write("                top: 0;\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .contenedor-principal{\n");
      out.write("\n");
      out.write("                position: relative;\n");
      out.write("                z-index: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function presiona2() {\n");
      out.write("                setTimeout(function () {\n");
      out.write("                    window.location.replace('TremorSaviorLogIn.html');\n");
      out.write("                }, 0);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/script.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('.sidenav').sidenav();\n");
      out.write("                $(\".dropdown-trigger\").dropdown();\n");
      out.write("                $('.modal').modal();\n");
      out.write("                $('select').formSelect();\n");
      out.write("                $('.fixed-action-btn').floatingActionButton();\n");
      out.write("                $('.collapsible').collapsible();\n");
      out.write("                var elem = document.querySelector('.collapsible.expandable');\n");
      out.write("                var instance = M.Collapsible.init(elem, {\n");
      out.write("                    accordion: false\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            function revelarContra1() {\n");
      out.write("                var x = document.getElementById(\"contra\");\n");
      out.write("                if (x.type === \"password\") {\n");
      out.write("                    x.type = \"text\";\n");
      out.write("                } else {\n");
      out.write("                    x.type = \"password\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function revelarContra2() {\n");
      out.write("                var x = document.getElementById(\"ccontra\");\n");
      out.write("                if (x.type === \"password\") {\n");
      out.write("                    x.type = \"text\";\n");
      out.write("                } else {\n");
      out.write("                    x.type = \"password\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <nav class=\" black darken-1 nav-extended\">\n");
      out.write("            <div class=\"center nav-wrapper blue-grey\">\n");
      out.write("                <a href=\"#\" class=\"brand-logo center\">Tremor Savior</a>\n");
      out.write("                <a href=\"#\" data-target=\"mobile-demo\" class=\"sidenav-trigger\"><i class=\"material-icons right\">account_circle</i></a>\n");
      out.write("                <ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\n");
      out.write("                    <li><a class=\"dropdown-trigger\" href=\"#!\" data-target=\"dropdown1\"><i class=\"material-icons right\">account_circle</i>");

                        out.print(usua.getNombre());
                            
      out.write("<i class=\"material-icons right\">arrow_drop_down</i></a></li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div> \n");
      out.write("                            <div class=\"nav-wrapper white-text black  \" style=\"text-align: center\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"align-center hide-on-small-only\" ><a href=\"Home.jsp\">INICIO</a></li>\n");
      out.write("                    <li class=\"align-center hide-on-small-only\"><a href=\"#test2\">Localización</a></li>\n");
      out.write("                    <li class=\"align-center hide-on-small-only\"><a href=\"TremorSaviorContactosdeConfianza.jsp\">Contactos de Confianza</a></li>\n");
      out.write("                    <li class=\"align-center hide-on-small-only green darken-3\"> &nbsp; &nbsp; Datos de Cuenta &nbsp;&nbsp;</li>\n");
      out.write("                    <li class=\"align-center hide-on-small-only\"><a href=\"#test5\">Información de Supervivencia</a></li>\n");
      out.write("                    <li class=\"hide-on-med-and-up\"style=\"text-align: center\"><h5 style=\"text-align: center\">Bienvenido: ");
 out.print(usua.getNombre());
      out.write("</h5></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <ul id=\"dropdown1\" class=\"dropdown-content\">\n");
      out.write("\n");
      out.write("            <li><a href=\"#!\">Ver Perfil</a></li>\n");
      out.write("            <li class=\"divider\"></li>\n");
      out.write("            <li><a href=\"#!\">Dar de Baja</a></li>\n");
      out.write("            <li class=\"divider\"></li>\n");
      out.write("            <li><a href=\"cerrar\">Cerrar Sesión</a></li>\n");
      out.write("        </ul>        \n");
      out.write("        <ul class=\"sidenav\" id=\"mobile-demo\">\n");
      out.write("            <li><a href=\"sass.html\">Ver Perfil</a></li>\n");
      out.write("            <li><a href=\"badges.html\">Dar de Baja</a></li>\n");
      out.write("            <li><a href=\"cerrar\">Cerrar Sesión</a></li>\n");
      out.write("            <li class=\"tab align-center\"><a class=\"active\" href=\"#test1\">INICIO</a></li>\n");
      out.write("            <li class=\"align-center\"><a href=\"#test2\">Localización</a></li>\n");
      out.write("            <li class=\"align-center\" ><a >Directorio</a></li>\n");
      out.write("            <li class=\"align-center\"><a href=\"#test4\">Datos de Cuenta</a></li>\n");
      out.write("            <li class=\"align-center\"><a href=\"#test5\">Información de Supervivencia</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"contenedor-principal\">                   \n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div id=\"test1\" class=\"row white\" style=\"margin-top:10em; text-align: center\">\n");
      out.write("                    <h4>Tu información</h4>\n");
      out.write("                    <form action=\"registra\" method=\"post\">\n");
      out.write("                        <div class=\"input-field col s4\">\n");
      out.write("                            <input type=\"text\" class=\"validate\" onkeypress=\"letras()\" pattern=\"^[A-Z a-z \\u00E0-\\u00FC À-ÿ]+$\" name=\"nombre\" id=\"nombre\" required placeholder=\"Nombre(s)\">\n");
      out.write("                            <label for=\"nombre\">Nombre:</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s4\">\n");
      out.write("                            <input type=\"text\" class=\"validate\" onkeypress=\"letras()\"  pattern=\"^[A-Z a-z \\u00E0-\\u00FC À-ÿ]+$\" name=\"apellido_p\" id=\"apellido_p\" required placeholder=\"Apellido Paterno\">\n");
      out.write("                            <label for=\"apellido_p\">Primer Apellido:</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s4\">\n");
      out.write("                            <input type=\"text\" class=\"validate\" onkeypress=\"letras()\"  pattern=\"^[A-Z a-z \\u00E0-\\u00FC À-ÿ]+$\" name=\"apellido_m\" id=\"apellido_m\" required placeholder=\"Apellido Materno\">\n");
      out.write("                            <label for=\"apellido_m\">Segundo Apellido:</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s12 m6\">\n");
      out.write("                            <input type=\"text\" class=\"validate\" onkeypress=\"email()\"  pattern=\"^(([^<>()\\[\\]\\\\.,;:\\s@']+(\\.[^<>()\\[\\]\\\\.,;:\\s@']+)*)|('.+'))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$\"  name=\"correo\" id=\"correo\" required placeholder=\"Correo electronico\">\n");
      out.write("                            <label for=\"correo\">Correo:</label>\n");
      out.write("                        </div>   \n");
      out.write("                        <div class=\"input-field col s6 m3 l3\">\n");
      out.write("                            <input class=\" col s10 validate\" onchange=\"if (this.checkValidity())\n");
      out.write("                                        form.ccontra.pattern = this.value;\" onkeypress=\"alfanumerico()\"  type=\"password\" onkeypress=\"alfanumerico()\" pattern=\"^[A-Z a-z 0-9 \\u00E0-\\u00FC À-ÿ]+$\" name=\"contra\" id=\"contra\" required placeholder=\"Contraseña\">\n");
      out.write("                            <label for=\"contra\">Contraseña:</label><a class=\"btn-floating  btn-small col s2 transparent\" onclick=\"revelarContra1()\" style=\"text-align: center;padding: 0\"><i class=\"material-icons black-text left\">remove_red_eye</i></a>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s6 m3 l3\">\n");
      out.write("                            <input class=\"col s10 validate\" onkeypress=\"alfanumerico()\"  onchange=\"this.setCustomValidity(this.validity.patternMismatch ? '¡Por favor ingrese contraseñas que coincidan!' : '');\" type=\"password\" oninput=\"check(this)\" onkeypress=\"alfanumerico()\" pattern=\"^[A-Z a-z 0-9 \\u00E0-\\u00FC À-ÿ]+$\"  name=\"ccontra\" id=\"ccontra\" required placeholder=\"Confirma\">\n");
      out.write("                            <label for=\"ccontra\">Confirma Cont.</label><a class=\"btn-floating btn-small col s2 transparent\" onclick=\"revelarContra2()\" style=\"text-align: center; padding: 0\"><i class=\"material-icons black-text left\">remove_red_eye</i></a>\n");
      out.write("\n");
      out.write("                        </div>    \n");
      out.write("                        <div class=\"input-field col s6 m3 l3\">\n");
      out.write("                            <input type=\"date\" class=\"validate\" name=\"fechan\" required id=\"fechan\">\n");
      out.write("                            <label for=\"fechan\">Fecha de Nacimiento: </label>\n");
      out.write("                        </div>      \n");
      out.write("                        <div class=\"input-field col s6 m3 l3\">\n");
      out.write("                            <input type=\"text\" class=\"validate\" onkeypress=\"numerico()\"  pattern=\"^[0-9]+$\" name=\"nss\" id=\"nss\" required placeholder=\"NSS\">\n");
      out.write("                            <label for=\"nss\">No.de Seguro Social :</label>\n");
      out.write("                        </div>      \n");
      out.write("                        <div class=\"input-field col s6 m3 l3\">\n");
      out.write("                            <input type=\"text\"class=\"validate\" onkeypress=\"alfanumerico()\"  pattern=\"^[A-Z a-z 0-9 \\u00E0-\\u00FC À-ÿ]+$\"  name=\"csecreta\" id=\"csecreta\" required placeholder=\"Clave Secreta\">\n");
      out.write("                            <label for=\"csecreta\">Clave de Recuperación: </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s6 m3 l3\">\n");
      out.write("                            <select class=\"validate flow-text\" name=\"tsangre\" id=\"tsangre\">\n");
      out.write("                                <option selected disabled value=\"0\">Tipo de sangre</option>\n");
      out.write("                                <option value=\"1\">A+</option>\n");
      out.write("                                <option value=\"2\">A-</option>\n");
      out.write("                                <option value=\"3\">B+</option>\n");
      out.write("                                <option value=\"4\">B-</option>\n");
      out.write("                                <option value=\"5\">AB+</option>\n");
      out.write("                                <option value=\"6\">AB-</option>\n");
      out.write("                                <option value=\"7\">O+</option>\n");
      out.write("                                <option value=\"8\">O-</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <button  class=\"btn-large green darken-1 lighten-3 white-text waves-effect waves-light col s6 m4 l4 offset-s3 offset-m4 offset-l4\" type=\"submit\" name=\"action\">Registrar<i class=\"white-text material-icons right\">send</i>\n");
      out.write("                        </button>  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");

                } else {
                    out.println("<script>alert('Inicia sesion primero');</script>");
                    out.print("<Script>presiona2();</Script>");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                out.println("<script>alert('Inicia sesion primero');</script>");
                out.print("<Script>presiona2();</Script>");
            }
        
      out.write("\n");
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
