<%-- 
    Document   : recursos
    Created on : 14 de dez. de 2021, 14:08:08
    Author     : Henrique
--%>

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
        <title>Recursos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
       <jsp:include page = "navbar.jsp"  flush = "true" />

        <div class="container" style="margin-top:50px">
            <CENTER>
                <h1 style="color: crimson">Protótipo II</h1>
                <h2 style="color: crimson">Versão 0.4</h2>

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Recursos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Captura de Erros HTML e Java</td>
                        </tr>
                        <tr>
                            <td>Servlet/JSP</td>
                        </tr>
                        <tr>
                            <td>Persistência de dados utilizando JDBC</td>
                        </tr>
                        <tr>
                            <td>Padrão DAO para acesso e controle de dados</td>
                        </tr>
                        <tr>
                            <td>Controle de Sessão</td>
                        </tr>
                        <tr>
                            <td>Eventos de Aplicação e de Sessão</td>
                        </tr>
                        <tr>
                            <td>Filtros</td>
                        </tr>
                        <tr>
                            <td>MVC</td>
                        </tr>
                        <tr>
                            <td>JavaBeans</td>
                        </tr>
                        <tr>
                            <td>Bootstrap</td>
                        </tr>
                        <tr>
                            <td>AdRotator</td>
                        </tr>
                    </tbody>
                </table>

                <br>
                <%--<a href="Controller?operacao=menu">Retornar ao menu</a>--%>
            </CENTER>
        </div>       
    </body>
</html>







