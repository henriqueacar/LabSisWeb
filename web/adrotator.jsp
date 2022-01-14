<%-- 
    Document   : adrotator
    Created on : 13 de jan. de 2022, 16:45:49
    Author     : Henrique
--%>
<%@page import="control.Rotator"%>

<jsp:useBean id = "rotator" scope = "session" class = "control.Rotator" />

    <% rotator.nextAd(); %>
    
    <p class = "big"><br></p>
      <p> 
         <a href = "<jsp:getProperty name = "rotator" 
            property = "link" />" target="_blank">

            <img src = "<jsp:getProperty name = "rotator"
               property = "image" />" alt = "advertisement" />
         </a>
      </p>

