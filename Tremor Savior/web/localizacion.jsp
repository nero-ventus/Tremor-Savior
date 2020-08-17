<%-- 
    Document   : localizacion
    Created on : 12/11/2018, 10:23:40 PM
    Author     : devil
--%>

<%@page import="com.tremor.impdao.impusuariodao"%>
<%@page import="com.tremor.modelo.dato_inicio"%>
<%@page import="com.tremor.dao.Iusuariodao"%>
<%@page import="com.tremor.modelo.usuario"%>
<%@page import="com.tremor.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Localizacion</title>
        
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
        <script>
            function presiona1(){
                setTimeout(function (){
                    window.location.replace('');
                },5000);
            }
            function presiona2(){
                setTimeout(function (){
                    window.location.replace('TremorSaviorLogIn.html');
                },5000);
            }
        </script>
        <style>
            body{
                background: url(imagenes/fondo1.jpg) no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }

            .tab a.active {
                color:rgb(252, 234, 37)!important;
                background-color:#33691e!important;
            }
            .tabs .tab a:hover {
                background-color: #8bc34a !important;
                color:#FFFFFF!important;
            }
            .tabs .tab a {
                color: #efebe9!important;
            }
            .tabs .indicator{
                background-color:#FFFFFF!important;
            }

            /* label color */
            .input-field label {
                color:black!important;
            }
            /* label focus color */
            .input-field input[type=text]:focus + label {
                color: green!important;

            }
            /* label underline focus color */
            .input-field input[type=text]:focus {
                border-bottom: 1px solid green!important;
                box-shadow: 0 1px 0 0 green!important;
            }
            /* valid color */
            .input-field input[type=text].valid {
                border-bottom: 1px green!important;
                box-shadow: 0 1px 0 0 green!important;
            }
            /* invalid color */
            .input-field input[type=text].invalid {
                border-bottom: 1px solid red!important;
                box-shadow: 0 1px 0 0 red!important;
            }
            /* icon prefix focus color */
            .input-field .prefix.active {
                color: green!important;
            }
            /* label focus color */
            .input-field input[type=text]:focus + label {
                color: green!important;
            }
            /* label underline focus color */
            .input-field input[type=text]:focus {
                border-bottom: 1px green!important;
                box-shadow: 0 1px 0 0 green!important;
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
    <style>
        /* Set the size of the div element that contains the map */
        #map {
          height: 600px;  /* The height is 400 pixels */
          width: 100%;  /* The width is the width of the web page */
          top: 20%;
        }
    </style>
    </head>
    <body onload="inicia()">
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
        %>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>

        <script>
            $(document).ready(function () {
                $('.sidenav').sidenav();
                $(".dropdown-trigger").dropdown();
                $('.modal').modal();
                $('.collapsible').collapsible();
                var elem = document.querySelector('.collapsible.expandable');
                var instance = M.Collapsible.init(elem, {
                    accordion: false
                });

            });
        </script>

        <nav class=" blue-grey darken-1 nav-extended">
            <div class="center nav-wrapper">
                <a href="#" class="brand-logo center">Tremor Savior</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons right">account_circle</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a class="dropdown-trigger" href="#!" data-target="dropdown1"><i class="material-icons right">account_circle</i><%
                        out.print(usua.getNombre());
                            %><i class="material-icons right">arrow_drop_down</i></a></li>

                </ul>

            </div> 
            <div class="nav-wrapper white-text black hide-on-small-only">
                <ul>
                    <li class="align-center green darken-3" ><a href="Home.jsp">&nbsp; &nbsp;  INICIO &nbsp; &nbsp;</a> </li>
                    <li class="align-center"><a href="localizacion.jsp">Localización</a></li>
                    <li class="align-center" ><a href="TremorSaviorContactosdeConfianza.jsp">Contactos de Confianza</a></li>
                    <li class="align-center"><a href="TremorSaviorDatosdeCuenta.jsp">Datos de Cuenta</a></li>
                    <li class="align-center"><a href="#test5">Información de Supervivencia</a></li>
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
        <div id="map"></div>
        <script>
            function inicia(){
                if(navigator.geolocation){
                    navigator.geolocation.getCurrentPosition(initMap);
                }
            }
            function initMap(position) {
                var lati=position.coords.latitude;
                var longi=position.coords.longitude;
                var posi = {lat: lati, lng: longi};
                var map = new google.maps.Map(document.getElementById('map'), {zoom: 18, center: posi});
                var marker = new google.maps.Marker({position: posi, map: map});
            }
        </script>
        <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCFPKaKfsROx1V0gzxcSnSScF5CqkJc4qY&callback=initMap">
        </script>
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