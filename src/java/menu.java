/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Henrique
 */
public class menu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            String loggedIn = null;
            
            HttpSession session = request.getSession(true);
            loggedIn = (String) session.getAttribute("loggedIn");
            
            if (loggedIn != null && loggedIn.equals("TRUE")){
                response.sendRedirect("menujsp.jsp");
            }
            else{
                String usuario_input = request.getParameter("usuario");
                String senha_input = request.getParameter("senha");
                
                if(usuario_input != null){
                    if(login(usuario_input, senha_input)){
                        session.setAttribute("loggedIn", "TRUE");
                        response.sendRedirect("menujsp.jsp");
                    }
                    else{
                        session.setAttribute("msg", "Senha inválida.");
                        response.sendRedirect("login.jsp");
                    }
                }
                else{
                    session.setAttribute("msg", "Sessão expirada.");
                    response.sendRedirect("login.jsp");
                }
            }
    }
    
    public boolean login(String usuario_input, String senha_input) throws ServletException{
        ServletContext sc = getServletContext();
        //USUARIO_DB E SENHA_DB PEGOS VIA PARAMETROS DE CONTEXTO
        String usuario_db = sc.getInitParameter("usuario_db");
        String senha_db = sc.getInitParameter("senha_db");
        
        boolean result = false;
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        String DB_URL = "jdbc:derby://localhost:1527/labsisweb";
        String resp = "EXECUTOU";
        
        //  Database credentials
        Connection conn = null;
        Statement stmt = null;
        
        try {
                // Register JDBC driver
                Class.forName(JDBC_DRIVER);

                // Open a connection
                conn = DriverManager.getConnection(DB_URL, usuario_db, senha_db);

                // Execute SQL query
                stmt = conn.createStatement();
                String sql;

                sql = "SELECT USUARIO, SENHA FROM ADMINUSER.USUARIO WHERE USUARIO = '"
                        + usuario_input + "' and SENHA='" + senha_input + "'";

                ResultSet rs = stmt.executeQuery(sql);

                // Extract data from result set
                if (rs.next()) {
                    result = true;
                }
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
            if(result){
                return true;
            }
            
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
