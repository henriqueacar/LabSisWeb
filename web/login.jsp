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
        <CENTER>
        <h1>UFJF - Depto. de Ciência da Computação</h1>
        <h2>Laboratório de Programação de Sistemas Web</h2>
        <h2 style="color: crimson;">Protótipo II</h2>
        <p style="font-weight: bold">Desenvolvedor: Henrique de Almeida Cardoso</p>
        <form action="Controller" method="POST">
            <div>
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
                    <%if(msg != null){%>
                        <p style="color:red;"><%=msg%></p>
                        <% session.removeAttribute("msg"); 
                    }%>
                </div>
            </div>
        </form>
        </CENTER>
    </body>
</html>
