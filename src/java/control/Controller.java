package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DaoUsuario;
import model.Usuario;

/**
 *
 * @author Henrique
 */
public class Controller extends HttpServlet {
    private String usuario_db;
    private String senha_db;
    
    @Override
    public void init(){
        usuario_db = getServletContext().getInitParameter("usuario_db");
        senha_db = getServletContext().getInitParameter("senha_db");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        HttpSession session = null;
        String loggedIn = null;
        RequestDispatcher rd = null;
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String operacao = request.getParameter("operacao");
        
        session = request.getSession(true);
        
        if(operacao != null && operacao.equals("login")){
            DaoUsuario dao = new DaoUsuario(usuario_db, senha_db);
            Usuario temp = dao.buscar(usuario);
            if(temp != null && senha != null && temp.getPassword().equals(senha)){
                session.setAttribute("loggedIn", "TRUE");
                session.setAttribute("usuario", usuario);
                rd = request.getRequestDispatcher("menujsp.jsp");
                rd.forward(request, response);
            }
            else{
                session.setAttribute("loggedIn", "FALSE");
                session.setAttribute("msg", "Usuário ou senha incorretos");
                rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
        else{
            loggedIn = (String) session.getAttribute("loggedIn");
            if(loggedIn == null || !loggedIn.equals("TRUE")){
                rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
            else{
                switch(operacao){
                    case "menu":
                        rd = request.getRequestDispatcher("menujsp.jsp");
                        rd.forward(request, response);
                        break;
                    case "sair":
                        session.setAttribute("loggedIn", "FALSE");
                        rd = request.getRequestDispatcher("login.jsp");
                        rd.forward(request, response);
                        break;
                    case "erroJava":
                        throw new ServletException();
                    case "recursos":
                        rd = request.getRequestDispatcher("recursos.jsp");
                        rd.forward(request, response);
                        break;
                    case "lista":
                        rd = request.getRequestDispatcher("lista.jsp");
                        rd.forward(request, response);
                        break;
                    case "welcome":
                        rd = request.getRequestDispatcher("welcome.html");
                        rd.forward(request, response);
                        break;
                    case "erroHTML":
                        rd = request.getRequestDispatcher("errohtml.html");
                        rd.forward(request, response);
                        break;
                    default:
                        session.setAttribute("loggedIn", "FALSE");
                        rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                        break;
                }
            }
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
