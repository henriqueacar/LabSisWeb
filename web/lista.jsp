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
<html style="background-color: gainsboro">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
    </head>
    <body>
    <CENTER>
        <% 
            ServletContext sc = getServletContext();
            String usuario_db = sc.getInitParameter("usuario_db");
            String senha_db = sc.getInitParameter("senha_db");
            
            DaoUsuario dao = new DaoUsuario(usuario_db, senha_db);
            %>
            
            <h2 style="color: crimson">Lista de Usuários</h2>
            <h3>
            <%
            ArrayList<Usuario> usuarios = new ArrayList<>();
            usuarios = dao.buscarTodos();
            int i = 0;
            while(usuarios.size()>i){
                out.println(usuarios.get(i).getUser());
                out.println("<br>");
                i++;
            }
        %>
        </h3>
        <br>
        <a href="Controller?operacao=menu">Retornar ao Menu</a>
    </CENTER>
    </body>
</html>
