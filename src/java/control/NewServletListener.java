/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Henrique
 */
public class NewServletListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    int userCount = 0;
    ServletContext servletContext;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        servletContext.setAttribute("userCount", Integer.toString(userCount));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        if(se.getName().equals("loggedIn")){
            String temp = (String) se.getValue();
            if(temp != null && temp.equals("TRUE"))
                userCount++;
        }else
            userCount--;
        servletContext.setAttribute("userCount", Integer.toString(userCount));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        if(se.getName().equals("loggedIn")){
            String temp = (String) se.getValue();
            if(temp != null && temp.equals("TRUE"))
                userCount++;
            else
                userCount--;
            servletContext.setAttribute("userCount", Integer.toString(userCount));
        }
    }
}
