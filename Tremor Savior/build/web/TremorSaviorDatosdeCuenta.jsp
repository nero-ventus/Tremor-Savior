<%-- 
    Document   : Home
    Created on : 30/10/2018, 12:41:28 AM
    Author     : devil
--%>

<%@page import="com.tremor.modelo.datos_vitales"%>
<%@page import="com.tremor.impdao.impdatos_vitales"%>
<%@page import="com.tremor.dao.Idatos_vitalesdao"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.tremor.impdao.impusuariodao"%>
<%@page import="com.tremor.dao.Iusuariodao"%>
<%@page import="com.tremor.modelo.usuario"%>
<%@page import="com.tremor.modelo.dato_inicio"%>
<%@page import="com.tremor.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TremorSavior-Datos de Cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="icon" type="image/png" href="imagenes/icono.png" />

        <link rel="shortcut icon" href="favicon.ico"> 
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link rel="stylesheet" href="css/materialize.min.css" media="screen,projection">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBCKiIqCdZGrVxx06LSbe7uG3zXOq1Cz5k&callback=initMap" async defer></script>

        <style>
            body{
                background: url(imagenes/fondoprinci.png) no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            } 
            .input-field label {
                color: black!important;
            }
            /* label focus color */
            .input-field input[type=text]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=text]:focus {
                border-bottom: 1px solid green! important;
                box-shadow: 0 1px 0 0 green ! important;
            }

            .input-field input[type=text].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }

            .input-field input[type=text].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;
            }
            /* icon prefix focus color */
            .input-field .prefix.active {
                color: green;
            }
            .input-field input[type=password]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=password]:focus {
                border-bottom: 1px solid green! important;
                box-shadow: 0 1px 0 0 green ! important;
            }

            .input-field input[type=password].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=password].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }
            .input-field input[type=date]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=date]:focus {
                border-bottom: 1px solid green! important;
                box-shadow: 0 1px 0 0 green ! important;
            }

            .input-field input[type=date].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=date].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }
            ul.dropdown-content.select-dropdown li span {
                color: green; /* no need for !important :) */
            } 
            nav{
                position: fixed;
                top: 0;
                z-index: 1;
            }

            .contenedor-principal{

                position: relative;
                z-index: 0;
            }

        </style>
        <script>
            function presiona2() {
                setTimeout(function () {
                    window.location.replace('TremorSaviorLogIn.html');
                }, 0);
            }
        </script>
    </head>
    <body>
        <%
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
                    Idatos_vitalesdao contraladv=new impdatos_vitales();
                    datos_vitales dvs=contraladv.traedatos_vitales(correo);
        %>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>

        <script>
            $(document).ready(function () {
                $('.sidenav').sidenav();
                $(".dropdown-trigger").dropdown();
                $('.modal').modal();
                $('select').formSelect();
                $('.fixed-action-btn').floatingActionButton();
                $('.collapsible').collapsible();
                var elem = document.querySelector('.collapsible.expandable');
                var instance = M.Collapsible.init(elem, {
                    accordion: false
                });

            });
        </script>
        <script>

            function revelarContra1() {
                var x = document.getElementById("contra");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
            function revelarContra2() {
                var x = document.getElementById("ccontra");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }

        </script>

        <nav class=" black darken-1 nav-extended">
            <div class="center nav-wrapper blue-grey">
                <a href="#" class="brand-logo center">Tremor Savior</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons right">account_circle</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a class="dropdown-trigger" href="#!" data-target="dropdown1"><i class="material-icons right">account_circle</i><%
                        out.print(usua.getNombre());
                            %><i class="material-icons right">arrow_drop_down</i></a></li>

                </ul>

            </div> 
                            <div class="nav-wrapper white-text black  " style="text-align: center">
                <ul>
                    <li class="align-center hide-on-small-only" ><a href="Home.jsp">INICIO</a></li>
                    <li class="align-center hide-on-small-only"><a href="localizacion.jsp">Localización</a></li>
                    <li class="align-center hide-on-small-only"><a href="TremorSaviorContactosdeConfianza.jsp">Contactos de Confianza</a></li>
                    <li class="align-center hide-on-small-only green darken-3"> &nbsp; &nbsp; Datos de Cuenta &nbsp;&nbsp;</li>
                    <li class="align-center hide-on-small-only"><a href="#test5">Información de Supervivencia</a></li>
                    <li class="hide-on-med-and-up"style="text-align: center"><h5 style="text-align: center">Bienvenido: <% out.print(usua.getNombre());%></h5></li>
                </ul>
            </div>
        </nav>
        <ul id="dropdown1" class="dropdown-content">

            <li><a href="TremorSaviorDatosdeCuenta.jsp">Ver Perfil</a></li>
            <li class="divider"></li>
            <li><a href="elimina_usua">Dar de Baja</a></li>
            <li class="divider"></li>
            <li><a href="cerrar">Cerrar Sesión</a></li>
        </ul>        
        <ul class="sidenav" id="mobile-demo">
            <li><a href="TremorSaviorDatosdeCuenta.jsp">Ver Perfil</a></li>
            <li><a href="elimina_usua">Dar de Baja</a></li>
            <li><a href="cerrar">Cerrar Sesión</a></li>
            <li class="tab align-center"><a class="active" href="Home.jsp">INICIO</a></li>
            <li class="align-center"><a href="localizacion.jsp">Localización</a></li>
            <li class="align-center" ><a >Directorio</a></li>
            <li class="align-center"><a href="TremorSaviorDatosdeCuenta.jsp">Datos de Cuenta</a></li>
            <li class="align-center"><a href="#test5">Información de Supervivencia</a></li>
        </ul>
        <div class="contenedor-principal">                   
            <div class="container">
                <div id="test1" class="row white" style="margin-top:10em; text-align: center">
                    <h4>Tu información</h4>
                    <form action="actualiza_usuario" method="post">
                        <div class="input-field col s4">
                            <input type="text" value="<%out.print(usua.getNombre());%>" class="validate" onkeypress="letras()" pattern="^[A-Z a-z \u00E0-\u00FC À-ÿ]+$" name="nombre" id="nombre" required placeholder="Nombre(s)">
                            <label for="nombre">Nombre:</label>
                        </div>
                        <div class="input-field col s4">
                            <input type="text" value="<%out.print(usua.getApellido_p());%>" class="validate" onkeypress="letras()"  pattern="^[A-Z a-z \u00E0-\u00FC À-ÿ]+$" name="apellido_p" id="apellido_p" required placeholder="Apellido Paterno">
                            <label for="apellido_p">Primer Apellido:</label>
                        </div>
                        <div class="input-field col s4">
                            <input type="text" value="<%out.print(usua.getApellido_m());%>" class="validate" onkeypress="letras()"  pattern="^[A-Z a-z \u00E0-\u00FC À-ÿ]+$" name="apellido_m" id="apellido_m" required placeholder="Apellido Materno">
                            <label for="apellido_m">Segundo Apellido:</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <input type="text" disabled value="<%out.print(usua.getCorreo());%>" class="validate" onkeypress="email()"  pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" id="correo" required placeholder="Correo electronico">
                            <label for="correo">Correo:</label>
                        </div>
                        <div class="hide">
                            <input type="text" value="<%out.print(usua.getCorreo());%>" name="correo">
                        </div>
                        <div class="input-field col s6 m3 l3">
                            <input value="<%out.print(ESAPI.encoder().decodeForHTML(contra));%>" class=" col s10 validate" onchange="if (this.checkValidity())
                                        form.ccontra.pattern = this.value;" onkeypress="alfanumerico()"  type="password" onkeypress="alfanumerico()" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$" name="contra" id="contra" required placeholder="Contraseña">
                            <label for="contra">Contraseña:</label><a class="btn-floating  btn-small col s2 transparent" onclick="revelarContra1()" style="text-align: center;padding: 0"><i class="material-icons black-text left">remove_red_eye</i></a>

                        </div>
                        <div class="input-field col s6 m3 l3">
                            <input value="<%out.print(ESAPI.encoder().decodeForHTML(contra));%>" class="col s10 validate" onkeypress="alfanumerico()"  onchange="this.setCustomValidity(this.validity.patternMismatch ? '¡Por favor ingrese contraseñas que coincidan!' : '');" type="password" oninput="check(this)" onkeypress="alfanumerico()" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$"  name="ccontra" id="ccontra" required placeholder="Confirma">
                            <label for="ccontra">Confirma Cont.</label><a class="btn-floating btn-small col s2 transparent" onclick="revelarContra2()" style="text-align: center; padding: 0"><i class="material-icons black-text left">remove_red_eye</i></a>

                        </div>    
                        <div class="input-field col s6 m3 l3">
                            <input value="<%out.print(usua.getFecha_n());%>" type="date" class="validate" name="fechan" required id="fechan">
                            <label for="fechan">Fecha de Nacimiento: </label>
                        </div>      
                        <div class="input-field col s6 m3 l3">
                            <input type="text" value="<%out.print(dvs.getNss());%>" class="validate" onkeypress="numerico()"  pattern="^[0-9]+$" name="nss" id="nss" required placeholder="NSS">
                            <label for="nss">No.de Seguro Social :</label>
                        </div>      
                        <div class="input-field col s6 m3 l3">
                            <input type="text" value="<%out.print(dvs.getCsecreta());%>"class="validate" onkeypress="alfanumerico()"  pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$"  name="csecreta" id="csecreta" required placeholder="Clave Secreta">
                            <label for="csecreta">Clave de Recuperación: </label>
                        </div>
                        <div class="input-field col s6 m3 l3">
                            <select class="validate flow-text" name="tsangre" id="tsangre">
                                <option selected disabled value="0">Tipo de sangre</option>
                                <option value="1">A+</option>
                                <option value="2">A-</option>
                                <option value="3">B+</option>
                                <option value="4">B-</option>
                                <option value="5">AB+</option>
                                <option value="6">AB-</option>
                                <option value="7">O+</option>
                                <option value="8">O-</option>
                            </select>
                        </div>
                            <script>
                                function cambiatsangre(){
                                    document.getElementById("tsangre").selectedIndex=<%out.print(dvs.getTipo_sangre());%>;
                                }
                                cambiatsangre();
                            </script>
                        <button  class="btn-large green darken-1 lighten-3 white-text waves-effect waves-light col s6 m4 l4 offset-s3 offset-m4 offset-l4" type="submit" name="action">Registrar<i class="white-text material-icons right">send</i>
                        </button>  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                    </form>
                </div>
            </div>


        </div>
        <%
                } else {
                    out.println("<script>alert('Inicia sesion primero');</script>");
                    out.print("<Script>presiona2();</Script>");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                out.println("<script>alert('Inicia sesion primero');</script>");
                out.print("<Script>presiona2();</Script>");
            }
        %>
    </body>
</html>
