/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Henrique
 */
public class ConFactory {
    

    public static Connection conexao(String usuario_db, String senha_db) throws ClassNotFoundException,
            SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection("jdbc:derby://localhost:1527/labsisweb", usuario_db, senha_db);
    }
    
}
