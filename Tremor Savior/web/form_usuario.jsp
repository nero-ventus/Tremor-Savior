<%-- 
    Document   : form_usuario
    Created on : 10/10/2018, 02:23:33 AM
    Author     : devil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <input type="text" name="nombre" id="nombre" required placeholder="Nombre(s)">
            <br>
            <br>
            <input type="text" name="apellido_p" id="apellido_p" required placeholder="Apellido Paterno">
            <br>
            <br>
            <input type="text" name="apellido_m" id="apellido_m" required placeholder="Apellido Materno">
            <br>
            <br>
            <input type="text" name="correo" id="correo" required placeholder="Correo electronico">
            <br>
            <br>
            <input type="password" name="contra" id="contra" required placeholder="Contraseña">
            <br>
            <br>
            <input type="password" name="ccontra" id="ccontra" required placeholder="Confirmar contraseña">
            <br>
            <br>
            <input type="date" name="fechan" id="fechan">
            <input type="text" name="nss" id="nss" required placeholder="NSS">
            <br>
            <br>
            <input type="text" name="csecreta" id="csecreta" required placeholder="Clave Secreta">
            <br>
            <br>
            <input type="text" name="tsangre" id="tsangre" placeholder="Tipo de sangre">
            <input type="submit">
        </form>
    </body>
</html>