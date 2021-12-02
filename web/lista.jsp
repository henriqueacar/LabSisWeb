<%-- 
    Document   : lista
    Created on : 1 de dez. de 2021, 18:34:07
    Author     : Henrique
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
    </head>
    <body>
        <% 
            ServletContext sc = getServletContext();
            String usuario_db = sc.getInitParameter("usuario_db");
            String senha_db = sc.getInitParameter("senha_db");
            
            boolean result = false;
            String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
            String DB_URL = "jdbc:derby://localhost:1527/labsisweb";
            String resp = "EXECUTOU";
        
            //  Database credentials
            Connection conn = null;
            Statement stmt = null;
            %>
            
            <h3>Lista de Usuários</h3>
            
            <%
           try {
                // Register JDBC driver
                Class.forName(JDBC_DRIVER);

                // Open a connection
                conn = DriverManager.getConnection(DB_URL, usuario_db, senha_db);

                // Execute SQL query
                stmt = conn.createStatement();
                String sql;

                sql = "SELECT USUARIO FROM USUARIO";

                ResultSet rs = stmt.executeQuery(sql);

                // Extract data from result set
                /*if (rs.isBeforeFirst()) {*/
                    //result = true;
                    while(rs.next()){
                        String usuario = rs.getString("USUARIO");
                        out.println(usuario);
                        out.println("<br>");
                    }
                /*}*/
                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                //Handle errors for JDBC
                //throw new ServletException(e);
                resp = e.getMessage();
                throw new ServletException(e);

            } catch (Exception e) {
                //Handle errors for Class.forName
                //throw new ServletException(e);
                resp = e.getMessage();
                throw new ServletException(e);
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    throw new ServletException(e);
                }// nothing we can do
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    throw new ServletException(e);
                }//end finally try
            } //end try
        %>
        <br>
        <a href="menujsp.jsp">Retornar ao Menu</a>
    </body>
</html>
