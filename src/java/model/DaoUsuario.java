/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Henrique
 */
public class DaoUsuario {
    private String usuario_db;
    private String senha_db;
    
    private Connection con;
    private Statement comando;

    public DaoUsuario(String usuario_db, String senha_db) {
        this.usuario_db = usuario_db;
        this.senha_db = senha_db;
    }
    
    public void apagar(String usuario) throws SQLException, ClassNotFoundException{
        conectar();
        try{
            comando.executeUpdate("DELETE FROM USUARIO WHERE usuario ='" + usuario +"';");
        } catch(SQLException e){
            imprimeErro("Erro ao apagar USUARIO ", e.getMessage());
        }finally{
            fechar();
        }
    }
    
    public ArrayList<Usuario> buscarTodos() throws ClassNotFoundException{
        conectar();
        ArrayList<Usuario> result = new ArrayList<>();
        ResultSet rs;
        
        try{
            rs = comando.executeQuery("SELECT * FROM USUARIO");
            while(rs.next()){
                Usuario temp = new Usuario();
                temp.setUser(rs.getString("USUARIO"));
                temp.setPassword(rs.getString("SENHA"));
                result.add(temp);
            }
            return result;
        } catch(SQLException e){
            imprimeErro("Erro ao buscar USUARIO ", e.getMessage());
            return null;
        } finally{
            fechar();
        }
    }
    
    /*
    */
    //Não funciona no momento, necessita ajustes
    public void atualizar(Usuario usuario) throws ClassNotFoundException{
        conectar();
        String com = "UPDATE USUARIO SET usuario ='" + usuario.getUser() 
                + "', senha = '" + usuario.getPassword() + "' WHERE usuario ='" +
                usuario.getUser() + "';";
        try{
            comando.executeQuery(com);
        }catch (SQLException e){
            imprimeErro("Erro ao atualizar USUARIO ", e.getMessage());
        }finally{
            fechar();
        }
    }
    
    public Usuario buscar(String usuario) throws ClassNotFoundException{
        conectar();
        ResultSet rs;
        Usuario temp = null;
        
        if(usuario == null)
            return null;
        
        try{
            String cmd = "SELECT * FROM USUARIO WHERE usuario = '" +
                    usuario + "'";
            rs = comando.executeQuery(cmd);
            if(rs.next()){
                temp = new Usuario();
                temp.setUser(rs.getString("USUARIO"));
                temp.setPassword(rs.getString("SENHA"));
            }
            return temp;
        } catch(SQLException e){
            imprimeErro("Erro ao buscar USUARIO ", e.getMessage());
            return null;
        }finally{
            fechar();
        }
    }
    
    public void insere(Usuario usuario) throws ClassNotFoundException{
        conectar();
        try{
            comando.executeUpdate("INSERT INTO USUARIO VALUES('"+usuario.getUser()+"','"
            +usuario.getPassword()+"'");
        } catch(SQLException e){
             imprimeErro("Erro ao inserir USUARIO ", e.getMessage());
        }finally{
            fechar();
        }
    }

    private void conectar() throws ClassNotFoundException{
        try{
            con = ConFactory.conexao(usuario_db, senha_db);
            comando = con.createStatement();
        } catch(ClassNotFoundException e){
            imprimeErro("Erro ao carregar o driver ", e.getMessage());
        } catch (SQLException e){
            imprimeErro("Erro ao conectar ", e.getMessage());
        }
    }
    
    private void fechar(){
        try{
            comando.close();
            con.close();
        } catch(SQLException e){
            imprimeErro("Erro ao fechar conexão ", e.getMessage());
        }
    }

    private void imprimeErro(String msg, String msgErro) {
        JOptionPane.showMessageDialog(null, msg, "Erro critico", 0);
        System.err.println(msg);
        System.out.println(msgErro);
        System.exit(0);
    }
}
