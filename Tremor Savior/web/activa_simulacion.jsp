<%-- 
    Document   : activa_simulacion
    Created on : 18/11/2018, 11:16:53 PM
    Author     : devil
--%>

<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int cual=0;
            try{
                cual=Integer.parseInt(request.getParameter("estado"));
            }
            catch(Exception e){
                e.printStackTrace();
                cual=0;
            }
            if(cual==2){
                String aux=config.getServletContext().getRealPath("/");
                String aux2="";
                aux+="";
                int aux3=0,aux4=0;
                for (int i=0;i<aux.length();i++) {
                    if(aux.charAt(i)==92){
                        aux2+="/";
                    }
                    else{
                        aux2+=aux.charAt(i);
                    }
                }
                aux3=aux2.indexOf("/build");
                aux4=aux3+6;
                String aux5=aux2.substring(0, aux3)+aux.substring(aux4);
                String filename="simula.txt";
                File archivo=new File(aux5+filename);
                FileWriter fw=new FileWriter(archivo);
                try{
                    PrintWriter outputStream=new PrintWriter(fw);
                    outputStream.print("Hay");
                    outputStream.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else{
                if(cual==1){
                    String aux=config.getServletContext().getRealPath("/");
                    String aux2="";
                    aux+="";
                    int aux3=0,aux4=0;
                    for (int i=0;i<aux.length();i++) {
                        if(aux.charAt(i)==92){
                            aux2+="/";
                        }
                        else{
                            aux2+=aux.charAt(i);
                        }
                    }
                    aux3=aux2.indexOf("/build");
                    aux4=aux3+6;
                    String aux5=aux2.substring(0, aux3)+aux.substring(aux4);
                    String filename="simula.txt";
                    File archivo=new File(aux5+filename);
                    FileWriter fw=new FileWriter(archivo);
                    try{
                        PrintWriter outputStream=new PrintWriter(fw);
                        outputStream.print("No");
                        outputStream.close();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        %>
        <form action="activa_simulacion.jsp" method="post">
            <select required name="estado">
                <option value="0" selected disabled>Seleciona un estado</option>
                <option value="1">Desactivado</option>
                <option value="2">Activado</option>
            </select>
            <input type="submit">
        </form>
    </body>
</html>
