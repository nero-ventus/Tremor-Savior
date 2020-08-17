
<%@page import="com.tremor.impdao.impusuariodao"%>
<%@page import="com.tremor.dao.Iusuariodao"%>
<%@page import="com.tremor.modelo.usuario"%>
<%@page import="com.tremor.modelo.dato_inicio"%>
<%@page import="com.tremor.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TremorSavior-HOME</title>
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
        <script>
            function hay(){
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                        var x=this.responseText;
                        if(x=="Hay"){
                            document.getElementById("contenedor1").className="container";
                            stop(verifica);
                        }
                   }
                };
                xhttp.open("GET","simula.txt", true);
                xhttp.send();
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
            // #map_1 {
            //  height: 438px;
            //width: 100%;
            // box-shadow: 0 8px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            //}
        </style>
        <script>
            function presiona2() {
                setTimeout(function () {
                    window.location.replace('TremorSaviorLogIn.html');
                }, 0);
            }
            function manda1(){
                if(navigator.geolocation){
                    navigator.geolocation.getCurrentPosition(function x(position){
                        var lati=position.coords.latitude;
                        var longi=position.coords.longitude;
                        document.getElementById("lati").value=lati;
                        document.getElementById("longi").value=longi;
                        document.getElementById("loca").action="estoy_bien";
                        document.getElementById("loca").submit();
                    });
                }
            }
            function manda2(){
                if(navigator.geolocation){
                    navigator.geolocation.getCurrentPosition(function x(position){
                        var lati=position.coords.latitude;
                        var longi=position.coords.longitude;
                        document.getElementById("lati").value=lati;
                        document.getElementById("longi").value=longi;
                        document.getElementById("loca").action="duda";
                        document.getElementById("loca").submit();
                    });
                }
            }
            function manda3(){
                if(navigator.geolocation){
                    navigator.geolocation.getCurrentPosition(function x(position){
                        var lati=position.coords.latitude;
                        var longi=position.coords.longitude;
                        document.getElementById("lati").value=lati;
                        document.getElementById("longi").value=longi;
                        document.getElementById("loca").action="necesito_ayuda";
                        document.getElementById("loca").submit();
                    });
                }
            }
        </script>
    </head>
    <body onload="verifica=setInterval('hay()',1000);">
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
                    <li class="align-center green darken-3">&nbsp; &nbsp;  INICIO &nbsp; &nbsp; </li>
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
            <li class="tab align-center"><a class="active" href="#test1">INICIO</a></li>
            <li class="align-center"><a href="localizacion.jsp">Localización</a></li>
            <li class="align-center" ><a >Directorio</a></li>
            <li class="align-center"><a href="TremorSaviorDatosdeCuenta.jsp">Datos de Cuenta</a></li>
            <li class="align-center"><a href="#test5">Información de Supervivencia</a></li>
        </ul>
        <div class="contenedor-principal">                   
            <div class="hide" id="contenedor1">
            <div id="test1" class="row s12 m12 l12" style="margin-top:8em">
                <div class="col s12 m4 l4">
                    <div class="card">
                        <div class="card-image">
                            <img src="imagenes/a1.jpg">
                            <a onclick="manda1()" class="btn-floating pulse btn-large halfway-fab waves-effect waves-light green"><i class="material-icons">gps_fixed</i></a>
                        </div>
                        <div class="card-content">
                            <h4 class="center">¡Estoy Bien!</h4><p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
                        </div>
                    </div>
                </div>
                <div class="col s12 m4 l4">
                    <div class="card">
                        <div class="card-image">
                            <img src="imagenes/a3.jpg">
                            <a onclick="manda2()" class="btn-floating pulse btn-large halfway-fab waves-effect waves-light orange"><i class="material-icons center">gps_fixed</i></a>
                        </div>
                        <div class="card-content">
                            <h4 class="center">No sé si saldré</h4><p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
                        </div>
                    </div>
                </div>
                <div class="col s12 m4 l4">
                    <div class="card">
                        <div class="card-image">
                            <img src="imagenes/a2.jpg">

                            <a onclick="manda3()" class="btn-floating pulse btn-large halfway-fab waves-effect waves-light red"><i class="material-icons center">gps_fixed</i></a>
                        </div>
                        <div class="card-content">
                            <h4 class="center">¡Necesito ayuda!</h4><p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
                        </div>
                    </div>
                </div>
            </div>



        </div>
            <div class="hide">
                <form id="loca" method="post">
                    <input type="text" name="lati" id="lati" required>
                    <input type="text" name="longi" id="longi" required>
                    <input type="submit" id="oprime">
                </form>
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
