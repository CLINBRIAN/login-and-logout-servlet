<%-- 
    Document   : Home
    Created on : Jun 16, 2024, 3:37:48 PM
    Author     : kamau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        
        Welcome <%=session.getAttribute("user")%>
        <br/><br/> Home page( Login success)
        <%--creating hyper links--%>
     <br/><br/>   <a href="./ProfilePageServlet">My Profile<a/>
       <br/><br/> <a href="./LogoutServlet">Logout<a/>
            </center>
    </body>
</html>
