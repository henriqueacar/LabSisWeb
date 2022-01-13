<%-- 
    Document   : lista
    Created on : 1 de dez. de 2021, 18:34:07
    Author     : Henrique
--%>

<%@page import="model.DaoUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <style>
        .table {
            margin-top: 5rem;
            width: 30% !important; 
        }
        table td {
            border: 0px solid black;
            border-collapse: collapse;
        }
        table th {
            text-align: center; 
            font-size: 30px;
        }

    </style>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
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
            <%
                ServletContext sc = getServletContext();
                String usuario_db = sc.getInitParameter("usuario_db");
                String senha_db = sc.getInitParameter("senha_db");
                DaoUsuario dao = new DaoUsuario(usuario_db, senha_db);
                ArrayList<Usuario> usuarios = new ArrayList<>();
            %>
            <CENTER>
            <table class="table table-hover text-center">
                <thead>
                    <tr>
                        <th style="color: crimson">Lista de Usuários</th>
                    </tr>
                </thead>
                <tbody>
                            <%
                                usuarios = dao.buscarTodos();
                                int i = 0;
                                while (usuarios.size() > i) {
                                    out.println("<tr><td>");
                                    out.println(usuarios.get(i).getUser());
                                    out.println("</td></tr>");
                                    i++;
                                }
                            %>
                </tbody>
            </table>
            </CENTER>
            <br>
            <%--<a href="Controller?operacao=menu">Retornar ao Menu</a>--%>
            <jsp:include page = "adrotator.jsp"  flush = "true" />
        </div>
    </body>
</html>
