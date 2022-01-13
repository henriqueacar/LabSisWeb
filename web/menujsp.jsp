<%-- 
    Document   : menujsp
    Created on : 1 de dez. de 2021, 19:28:52
    Author     : Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body style="text-align:center;">
        <h1 style="color: crimson">Menu</h1>
        <%
            String usuario = (String) session.getAttribute("usuario");
            String userCount = (String) session.getServletContext().getAttribute("userCount");
        %>
        <%if(usuario != null){%>
            <p style="color: black; font-weight: bold">Usuário: <%=usuario%></p>
        <%}%>
        <%if(userCount != null){%>
            <p style="color: black; font-weight: bold">Usuário: <%=userCount%></p>
        <%}%>
        <h3><a href="Controller?operacao=welcome">Welcome</a></h3>
        <h3><a href="Controller?operacao=recursos">Recursos</a></h3>
        <h3><a href="Controller?operacao=lista">Lista</a></h3>
        <h3><a href="Controller?operacao=erroHTML">Erro HTML</a></h3>
        <h3><a href="Controller?operacao=erroJava">Erro JAVA</a></h3>
        <h3><a href="Controller?operacao=sair">Sair</a></h3>
        
    </body>
</html>
