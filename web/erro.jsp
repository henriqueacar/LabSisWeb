<%-- 
    Document   : erro
    Created on : 1 de dez. de 2021, 19:02:05
    Author     : Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="Controller?operacao=menu">LabSisWeb</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="Controller?operacao=welcome">Welcome</a></li>
                    <li><a href="Controller?operacao=recursos">Recursos</a></li>
                    <li><a href="Controller?operacao=lista">Lista</a></li>
                    <li><a href="Controller?operacao=erroHTML">Erro HTML</a></li>
                    <li><a href="Controller?operacao=erroJava">Erro JAVA</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="Controller?operacao=sair"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>
                </ul>
            </div>
        </nav>
        <div class="container text-center" style="margin-top:50px">
            <h1>Ocorreu um erro inesperado. </h1>
            <br>
            <%--<a href="Controller?operacao=sair">Sair</a>--%>
        </div>
    </body>
</html>
