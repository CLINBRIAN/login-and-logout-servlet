/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author kamau
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

 


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
        //deal with doPost method
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //accept username and password from index.html file
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //database
        try{
            //open connection
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
           PreparedStatement pst = conn.prepareStatement("SELECT * FROM login where username ='"+username+"' and password='"+password+"'");
           ResultSet rs =pst.executeQuery();
           
           if(rs.next()){
               HttpSession session =request.getSession();
               String name = request.getParameter("username");
               session.setAttribute("user", name);
               //go to home.html page
               response.sendRedirect("Home.jsp");
           
           }else{
               out.println("wrong credentials");
           
           }
           conn.close();
        
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
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
