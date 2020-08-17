<%-- 
    Document   : Home
    Created on : 30/10/2018, 12:41:28 AM
    Author     : devil
--%>

<%@page import="com.tremor.modelo.contacto"%>
<%@page import="com.tremor.modelo.contacto_confianza"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tremor.impdao.impcontacto"%>
<%@page import="com.tremor.dao.Icontacto"%>
<%@page import="com.tremor.impdao.impcontacto_confianza"%>
<%@page import="com.tremor.dao.Icontacto_confianzadao"%>
<%@page import="com.tremor.impdao.impusuariodao"%>
<%@page import="com.tremor.dao.Iusuariodao"%>
<%@page import="com.tremor.modelo.usuario"%>
<%@page import="com.tremor.modelo.dato_inicio"%>
<%@page import="com.tremor.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TremorSavior-Contactos de Confianza</title>
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
        <script type="text/javascript" src="js/validaciones.js"></script>

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

            tbody {
                display:block;
                height:400px;
                overflow:auto;
            }
            thead, tbody tr {
                display:table;
                width:100%;
                table-layout:fixed;
            }
            thead {
                width: calc( 100% - 1em )
            }
            table {
                width:100%;
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
            .input-field input[type=password]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=search]:focus {
                border-bottom: 1px solid green! important;
                box-shadow: 0 1px 0 0 green ! important;
            }

            .input-field input[type=search].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=search].valid {
                border-bottom: 1px solid #76ff03!important;
                
            ul.dropdown-content.select-dropdown li span {
                color: green; /* no need for !important :) */
            } 
            .switch label input[type=checkbox]:checked+.lever:after {
                background-color: green;
            }
            .switch label input[type=checkbox]:checked+.lever {
                background-color: lightgreen;
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
                    <li class="align-center"><a href="Home.jsp">INICIO </a></li>
                    <li class="align-center"><a href="localizacion.jsp">Localización</a></li>
                    <li class="align-center green darken-3"> &nbsp;&nbsp;Contactos de Confianza&nbsp;&nbsp;</li>
                    <li class="align-center"><a href="TremorSaviorDatosdeCuenta.jsp">Datos de Cuenta</a></li>
                    <li class="align-center"><a href="">Información de Supervivencia</a></li>
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
        <div class="container">
            <div id="test1" class="row">
                <div class="responsive-table table-status-sheet"style="margin-top: 2em">
                    <table class="bordered white">
                        <thead>
                            <tr>
                                <th class="center flow-text"><H5>Agrega aqui tus contactos de confianza</H5></th>
                                <th class="hide-on-small-only">
                                    <form>
                                        <div class="input-field" style="padding: 0">
                                            <input id="search" type="search" required>
                                            <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                                            <i class="material-icons">close</i>
                                        </div>
                                    </form>
                                </th>
                                <th class="center flow-text">
                                    <a class=" btn modal-trigger right green darken-3 flow-text" href="#agregarcontacto">  <i class="material-icons right">group_add</i>Añadir Contacto</a>

                                    <!-- Modal Structure -->
                                    <div id="agregarcontacto" class="modal" style="margin-top: 1em">
                                        <div class="modal-content">
                                            <h4>¡Agrega un contacto!</h4>
                                            <form action="registra_contacc" method="post">
                                                <div class="input-field col s12 m4 l4">
                                                    <input placeholder="Nombre del Contacto" pattern="^[A-Za-z ]+$"  onkeypress="letras()" id="nombre" name="nombre" type="text" class="validate" required>
                                                    <label for="nombre">Nombre</label>
                                                </div>
                                                <div class="input-field col s12 m4 l4">
                                                    <input placeholder="Apellido P. del Contacto" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_p" name="apellido_p" type="text" class="validate" required>
                                                    <label for="apellido_p">Apellido Paterno</label>
                                                </div>
                                                <div class="input-field col s12 m4 l4">
                                                    <input placeholder="Apellido M. del Contacto" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_m" name="apellido_m" type="text" class="validate" required>
                                                    <label for="apellido_m">Apellido Materno</label>
                                                </div>
                                                <div class="input-field col s6">
                                                    <input placeholder="Num. Telefónico" pattern="^[0-9]+$" onkeypress="numerico()" id="telefono" name="telefono" type="text" class="validate">
                                                    <label for="telefono">Teléfono</label>
                                                </div>
                                                <div class="input-field col s6">
                                                    <input placeholder="E-mail" id="correo" onkeypress="email()" pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" name="correo" type="text" class="validate">
                                                    <label for="correo">Correo</label>
                                                </div>
                                                <button class="btn green darken-3" type="submit" name="action">Guardar<i class="material-icons right">save</i>
                                                </button>

                                            </form>
                                        </div>

                                    </div></th>
                            </tr>
                            <tr>
                                <th class="hide-on-med-and-up" colspan="2">
                                    <form>
                                        <div class="input-field" style="padding: 0">
                                            <input id="search" type="search" required>
                                            <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                                            <i class="material-icons">close</i>
                                        </div>
                                    </form>
                                </th>
                            </tr>
                        </thead>
                        <tbody id="milista">
                            <tr>
                                <td>
                                     <%
                                         Icontacto_confianzadao controla_contacc=new impcontacto_confianza();
                                         Icontacto controla_contac=new impcontacto();
                                         ArrayList<contacto_confianza> lista_conatctosc=controla_contacc.traecontactos(correo);
                                         if(lista_conatctosc.size()>0){
                                             for(int i=0;i<lista_conatctosc.size();i++){
                                                 ArrayList<contacto> lista_contactos=controla_contac.traeContactos(lista_conatctosc.get(i).getId_contactoc());
                                     %>
                                         <ul class="collection col s12">
                                        <li class="collection-item avatar">
                                            <i class="material-icons circle green darken-3">account_circle</i>
                                            
                                            <p>Nombre: <%out.print(lista_conatctosc.get(i).getNombre());%></p>
                                            <%
                                                for (int j=0;j<lista_contactos.size();j++) {
                                                    if(lista_contactos.get(j).getId_tipoc()==2){
                                                        out.println("<p>Celular: "+lista_contactos.get(j).getContacto()+" </p>");
                                                    }
                                                    if(lista_contactos.get(j).getId_tipoc()==1){
                                                        out.println("<p>Correo: "+lista_contactos.get(j).getContacto()+" </p>");
                                                    }
                                                }
                                            %>
                                            <a class=" secondary-content btn modal-trigger green darken-3" href="#editar<%out.print((i+1));%>"><i class="material-icons right">edit</i>Editar</a>
                                            <!-- Modal Structure -->
                                            <div id="editar<%out.print((i+1));%>" class="modal" style="margin-top: 1em">
                                                <div class="modal-content" style="text-align: center">
                                                    <h5>Edita tu contacto</h5>
                                                    <div class="switch col s12 m12 l12 ">
                                                        Editar:<br>
                                                        <label>
                                                            No
                                                            <input id="switch_<%out.print((i+1));%>" type="checkbox" onclick="hab_<%out.print((i+1));%>()">
                                                            <span class="lever"></span>
                                                            Si
                                                        </label>          
                                                    </div>
                                                            <form action="actualiza_contactoc" method="post" id="form<%out.print((i+1));%>">
                                                        <div class="hide">
                                                            <input type="number" name="idcontacc" value="<%out.print(lista_conatctosc.get(i).getId_contactoc());%>" required>
                                                        </div>
                                                        <div class="input-field col s12 m4 l4">
                                                            <input disabled value="<%out.print(lista_conatctosc.get(i).getNombre());%>" placeholder="Nombre del Contacto" pattern="^[A-Za-z ]+$"  onkeypress="letras()" id="nombre_numcontac_obtenido" name="nombre" type="text" class="validate" required>
                                                            <label for="nombre">Nombre</label>
                                                        </div>
                                                        <div class="input-field col s12 m4 l4">
                                                            <input disabled value="<%out.print(lista_conatctosc.get(i).getApellido_p());%>" placeholder="Apellido P. del Contacto" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_p_numcontac_obtenido" name="apellido_p" type="text" class="validate" required>
                                                            <label for="apellido_p">Apellido Paterno</label>
                                                        </div>
                                                        <div class="input-field col s12 m4 l4">
                                                            <input disabled value="<%out.print(lista_conatctosc.get(i).getApellido_m());%>" placeholder="Apellido M. del Contacto" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_m_numcontac_obtenido" name="apellido_m" type="text" class="validate" required>
                                                            <label for="apellido_m">Apellido Materno</label>
                                                        </div>
                                                        <%
                                                        if(lista_contactos.size()==2){
                                                            if(lista_contactos.get(0).getId_tipoc()==1){
                                                            %>
                                                                <div class="input-field col s6">
                                                                    <input disabled value="<%out.print(lista_contactos.get(1).getContacto());%>" placeholder="Num. Telefónico" pattern="^[0-9]+$" onkeypress="numerico()" id="telefono_numcontac_obtenido" name="telefono" type="text" class="validate">
                                                                    <label for="telefono">Teléfono</label>
                                                                </div>
                                                                <div class="input-field col s6">
                                                                    <input disabled value="<%out.print(lista_contactos.get(0).getContacto());%>" placeholder="E-mail" id="correo_numcontac_obtenido" onkeypress="email()" pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" name="correo" type="text" class="validate">
                                                                    <label for="correo">Correo</label>
                                                                </div>
                                                            <%
                                                            }
                                                            if(lista_contactos.get(0).getId_tipoc()==2){
                                                            %>
                                                                <div class="input-field col s6">
                                                                    <input disabled value="<%out.print(lista_contactos.get(0).getContacto());%>" placeholder="Num. Telefónico" pattern="^[0-9]+$" onkeypress="numerico()" id="telefono_numcontac_obtenido" name="telefono" type="text" class="validate">
                                                                    <label for="telefono">Teléfono</label>
                                                                </div>
                                                                <div class="input-field col s6">
                                                                    <input disabled value="<%out.print(lista_contactos.get(1).getContacto());%>" placeholder="E-mail" id="correo_numcontac_obtenido" onkeypress="email()" pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" name="correo" type="text" class="validate">
                                                                    <label for="correo">Correo</label>
                                                                </div>
                                                            <%
                                                            }
                                                        }
                                                        else{
                                                            if(lista_contactos.size()==1){
                                                                if(lista_contactos.get(0).getId_tipoc()==1){
                                                                %>
                                                                    <div class="input-field col s6">
                                                                        <input disabled value="" placeholder="Num. Telefónico" pattern="^[0-9]+$" onkeypress="numerico()" id="telefono_numcontac_obtenido" name="telefono" type="text" class="validate">
                                                                        <label for="telefono">Teléfono</label>
                                                                    </div>
                                                                    <div class="input-field col s6">
                                                                        <input disabled value="<%out.print(lista_contactos.get(0).getContacto());%>" placeholder="E-mail" id="correo_numcontac_obtenido" onkeypress="email()" pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" name="correo" type="text" class="validate">
                                                                        <label for="correo">Correo</label>
                                                                    </div>
                                                                <%
                                                                }
                                                                if(lista_contactos.get(0).getId_tipoc()==2){
                                                                %>
                                                                    <div class="input-field col s6">
                                                                        <input disabled value="<%out.print(lista_contactos.get(0).getContacto());%>" placeholder="Num. Telefónico" pattern="^[0-9]+$" onkeypress="numerico()" id="telefono_numcontac_obtenido" name="telefono" type="text" class="validate">
                                                                        <label for="telefono">Teléfono</label>
                                                                    </div>
                                                                    <div class="input-field col s6">
                                                                        <input disabled value="" placeholder="E-mail" id="correo_numcontac_obtenido" onkeypress="email()" pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" name="correo" type="text" class="validate">
                                                                        <label for="correo">Correo</label>
                                                                    </div>
                                                                <%
                                                                }
                                                            }
                                                            else{
                                                                if(lista_contactos.size()==0){
                                                                    %>
                                                                    <div class="input-field col s6">
                                                                        <input disabled value="" placeholder="Num. Telefónico" pattern="^[0-9]+$" onkeypress="numerico()" id="telefono_numcontac_obtenido" name="telefono" type="text" class="validate">
                                                                        <label for="telefono">Teléfono</label>
                                                                    </div>
                                                                    <div class="input-field col s6">
                                                                        <input disabled value="" placeholder="E-mail" id="correo_numcontac_obtenido" onkeypress="email()" pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" name="correo" type="text" class="validate">
                                                                        <label for="correo">Correo</label>
                                                                    </div>
                                                                <%
                                                                }
                                                            }
                                                        }
                                                        %>
                                                        <div class="col s6">
                                                            <button class="btn green darken-3" type="submit" id="btn_numcontact_obtenido" name="action">Guardar<i class="material-icons right">save</i>
                                                            </button>
                                                        </div>
                                                        <div class="col s6  m6 l6 center-align" style="text-align: center">
                                                            <a class="waves-effect waves-light btn red modal-trigger" href="#dardebaja_<%out.print((i+1));%>">Dar De Baja<i class="material-icons right">delete_forever</i>  </a>
                                                            
                                                        </div>
                                                        <br><br><br><br><br><br><br><br><br><br><br><br><br>
                                                    </form>
                                                    <div id="dardebaja_<%out.print((i+1));%>" class="modal">
                                                        <div class="modal-content" style="text-align: center">
                                                            <h4>Dar de Baja</h4>
                                                            <p>¿Está seguro de eliminar este contacto?</p>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <div class="col s6">
                                                                <a href="" class="modal-close waves-effect red waves-red btn">Cancelar</a>
                                                            </div>
                                                            <div class="col s6">
                                                                <form action="elimina_contacc" method="post">
                                                                    <div class="hide">
                                                                        <input type="number" name="idcontacc" value="<%out.print(lista_conatctosc.get(i).getId_contactoc());%>" required>
                                                                    </div>
                                                                    <button class="btn green" type="submit" id="btnbaja_numcontact_obtenido" name="action">Eliminar<i class="material-icons right">check</i>
                                                                    </button>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <script>
                                                        function hab_<%out.print((i+1));%>() {
                                                            if (document.getElementById('switch_<%out.print((i+1));%>').checked)
                                                            {
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("nombre_numcontac_obtenido").disabled = false;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("apellido_p_numcontac_obtenido").disabled = false;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("apellido_m_numcontac_obtenido").disabled = false;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("telefono_numcontac_obtenido").disabled = false;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("correo_numcontac_obtenido").disabled = false;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("btn_numcontact_obtenido").disabled = false;

                                                            } else {
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("nombre_numcontac_obtenido").disabled = true;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("apellido_p_numcontac_obtenido").disabled = true;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("apellido_m_numcontac_obtenido").disabled = true;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("telefono_numcontac_obtenido").disabled = true;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("correo_numcontac_obtenido").disabled = true;
                                                                document.getElementById("form<%out.print((i+1));%>").elements.namedItem("btn_numcontact_obtenido").disabled = true;
                                                            }


                                                        }
                                                    </script>
                                                </div>
                                            </div>

                                        </li>
                                    </ul>
                                    <%
                                        }
                                    }
                                    else{
                                    %>
                                <th>No hay resigtros</th>
                                    <%
                                    }
                                    %> 
                                </td>           
                            </tr>

                        </tbody>
                    </table>
                </div>



            </div>
            <%
                    }
                    else {
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
