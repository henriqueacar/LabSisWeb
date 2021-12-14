
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique
 */
public class LoginDB {
    
        private static final String usuario_db = "adminuser";
        private static final String senha_db = "admin";
        private static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        private static final String DB_URL = "jdbc:derby://localhost:1527/labsisweb";
    
    public static boolean login(String usuario_input, String senha_input) throws ServletException{
        
        boolean result = false;
        
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
                throw new ServletException(e);

            } catch (Exception e) {
                //Handle errors for Class.forName
                //throw new ServletException(e);
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
}
