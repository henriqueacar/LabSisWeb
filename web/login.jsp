<%-- 
    Document   : login
    Created on : 1 de dez. de 2021, 21:27:50
    Author     : Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String msg = (String) session.getAttribute("msg");
%>
<html style="background-color: gainsboro">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1 style="text-align:center;">UFJF - Depto. de Ciência da Computação</h1>
        <h2 style="text-align:center;">Laboratório de Programação de Sistemas Web</h2>
        <h2 style="text-align:center;">Protótipo II</h2>
        <p style="text-align:center;">Desenvolvedor: Henrique de Almeida Cardoso</p>
        <form action="Controller" method="POST">
            <div style="text-align:center;">
                <div style=" margin-top: 5rem;">
                    <label>Usuário:</label>
                    <input type="text" name="usuario">
                    <br>
                </div>
                <div style=" margin-top: 0.3rem;">
                    <label style=" margin-right: 0.7rem;" >Senha:</label>
                    <input type="password" name="senha">
                    <br>
                    <button type="submit" name ="operacao" value="login" style=" margin-top: 0.3rem;">Login</button>
                    <%
                        if(msg != null){%>
                        <p style="color:red;"><%=msg%></p>
                        <% session.removeAttribute("msg"); 
                        }%>
                </div>
            </div>
        </form>
    </body>
</html>
