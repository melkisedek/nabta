/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package na.edu.nust.nabta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mel
 */
@WebServlet(name = "Registered", urlPatterns = {"/Registered"})
public class Registered extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
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
         try (PrintWriter out = response.getWriter()) {
            // Register mysql drivers 
            String drivers = "com.mysql.jdbc.Driver";
            System.setProperty("jdbc.drivers", drivers);
            // Register the JDBC driver
            Driver mysqlDriver = null;
            try {
                mysqlDriver = new com.mysql.jdbc.Driver();

            } catch (SQLException ex) {
                Logger.getLogger(Register.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            try {
                DriverManager.registerDriver(mysqlDriver);

            } catch (SQLException ex) {
                Logger.getLogger(Register.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            String connectionURL = "jdbc:mysql://localhost:3306/nabta";
            String userId = "admin";
            String password = "adminpass";
            Connection conn = null;
            Statement statement = null;
            String sql = null;
            ResultSet executeQuery = null;
            // Create the connection using the Driver manager, 
            // supply connectionURL, username, and password to getConnection method
            try {
                conn = DriverManager.getConnection(connectionURL, userId, password);
            } catch (SQLException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //will probably not be used in this code
                conn.setAutoCommit(false);
            } catch (SQLException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                statement = conn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }

            
                sql = "SELECT * FROM `VEHICLES` WHERE `REGISTERED`='1';";
                try {
                    executeQuery = statement.executeQuery(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }

            out.println("<!DOCTYPE html>");
            out.println("<html>\n" +
"    <head>\n" +
"        <link rel=\"icon\" type=\"image/ico\" href=\"img/favicon.ico\">\n" +
"        <title>View Vehicles</title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <!-- Bootstrap -->\n" +
"        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"        <!-- JQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
"        <!-- <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>-->\n" +
"        <script src=\"js/bootstrap.min.js\"></script>\n" +
"    </head>\n" +
"    <body>\n" +
"        <ul class=\"nav nav-pills\">\n" +
"            <li role=\"presentation\"><a href=\"index.jsp\">Home</a></li>\n" +
"            <li role=\"presentation\"><a href=\"agreement.jsp\">Register Vehicle</a></li>\n" +
"            <li role=\"presentation\"><a href=\"viewDetails.jsp\">View Registered Vehicle</a></li>\n" +
"            <li role=\"presentation\" class=\"active\"><a href=\"reports.jsp\">Reports</a></li>\n" +
"        </ul>");
            out.println("<h3>Vehicle Details</h3>");
            out.println("<table class=\"table table-bordered table-hover\">\n" +
"            <thead>\n" +
"		<tr>\n" +
"			<th>NABTA_ID</th>\n" +
"			<th>REGISTRATION</th>\n" +
"			<th>TYPE</th>\n" +
"			<th>MODEL</th>\n" +
"			<th>MASS</th>\n" +
"			<th>COLOUR</th>\n" +
"			<th>REGISTERATION STATUS</th>\n" +
"			<th>FEES_DUE(N$)</th>\n" +
"		</tr>\n"
                    + "<tbody>" +
"            ");
            while (executeQuery.next()) {
                String NABTA_ID = executeQuery.getString("NABTA_ID");
                String REGISTRATION = executeQuery.getString("REGISTRATION");
                String TYPE = executeQuery.getString("TYPE");
                String MODEL = executeQuery.getString("MODEL");
                String MASS = executeQuery.getString("MASS");
                String COLOUR = executeQuery.getString("COLOUR");
                int REGISTERED = executeQuery.getInt("REGISTERED");
                String registered = null; // status of registration
                if(REGISTERED==0){
                    registered = "<p style=\"color: red\">Not Registered</p>";
                } else
                    registered = "<p style=\"color: green\">Registered Vehicle</p>";
                double FEES_DUE = executeQuery.getDouble("FEES_DUE");
                out.println("<tr>");
                out.println("<td><p>" + NABTA_ID + "</p></td>");
                out.println("<td><p>" + REGISTRATION + "</p></td>");
                out.println("<td><p>" + TYPE + "</p></td>");
                out.println("<td><p>" + MODEL + "</p></td>");
                out.println("<td><p>" + MASS + " KG</p></td>");
                out.println("<td><p> " + COLOUR + "</p></td>");
                out.println("<td>"+registered+"</td>");
                out.println("<td><p>" + FEES_DUE + "0</p></td>"); 
                out.println("</tr>");
            }
            out.println("</tbody>\n" +
                "</table>");
                        
            out.println("<!--return to previous page-->\n" 
                    +"<button class=\"btn btn-default\" onclick=\"goBack()\">Go Back</button>\n" 
                    +"<script>\n" 
                    +"function goBack() {\n" 
                    +"  window.history.back();\n" 
                    +"}\n" 
                    +"</script>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Show all Registered Vehicles on the system";
    }// </editor-fold>

}
