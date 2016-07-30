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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mel
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

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
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                DriverManager.registerDriver(mysqlDriver);
            } catch (SQLException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
            String connectionURL = "jdbc:mysql://localhost:3306/nabta";
            String userId = "admin";
            String password = "adminpass"; 
            Connection conn = null;
            Statement statement = null;

            try {
                // Create the connection using the Driver manager, 
                // supply connectionURL, username, and password to getConnection method
                conn = DriverManager.getConnection(connectionURL, userId, password);
                conn.setAutoCommit(false);
                statement = conn.createStatement();
                //create the session object
                // get the user's session object
                // don't create session if one does exist
                HttpSession ses = request.getSession(true);
                
                //get all the parameters from session 
                String ownerNames = (String) ses.getAttribute("ownerNames");
                String ownerSurname = (String) ses.getAttribute("ownerSurname");
                String driverNames = (String) ses.getAttribute("driverNames");
                String driverSurname = (String) ses.getAttribute("driverSurname");
                String regNum = (String) ses.getAttribute("regNum");
                String nbtaID = (String) ses.getAttribute("nbtaID");
                String type = (String) ses.getAttribute("type");
                String fees = (String) ses.getAttribute("fees");
                String model = (String) ses.getAttribute("model");
                String mass = (String) ses.getAttribute("mass");
                String color = (String) ses.getAttribute("color");
                String cause = (String) ses.getAttribute("cause");
                String place = (String) ses.getAttribute("place");
                String date = (String) ses.getAttribute("date");
                String ownerID = (String) ses.getAttribute("ownerID");
                String driverID = (String) ses.getAttribute("driverID");
                String postAddr = (String) ses.getAttribute("postAddr");
                String residentAddr = (String) ses.getAttribute("residentAddr");
                String region = (String) ses.getAttribute("region");

                // create the sql statement
                String driversql = "insert into DRIVERS "
                        + "(DRIVER_ID,FIRST_NAMES,SURNAME) "
                        + "values('"+ driverID + "','" + driverNames + "','" 
                        + driverSurname + "')";
                String ownersql = "insert into OWNERS "
                        + "(OWNER_ID,DRIVER_ID,FIRST_NAMES,SURNAME,POSTAL_ADDR,RESIDENT_ADDR,REGION) "
                        + "values('" + ownerID + "','" + driverID + "','" + ownerNames + "','" 
                        + ownerSurname + "','" + postAddr + "','" 
                        + residentAddr +"','"+ region +"')";
                String vehiclesql = "insert into VEHICLES "
                        + "(NABTA_ID,OWNER_ID,DRIVER_ID,REGISTRATION,TYPE,MODEL,MASS,COLOUR,FEES_DUE) "
                        + "values('" + nbtaID + "','" + ownerID + "','" + driverID + "','" 
                        + regNum + "','" + type + "','" + model + "','" + mass + "','" 
                        + color + "','" + fees + "')";
                String accidentsql = "insert into ACCIDENTS "
                        + "(CAUSE,PLACE,DATE,REGISTRATION,OWNER_ID,DRIVER_ID) "
                        + "values('" + cause + "','" + place + "','" 
                        + date + "','" + regNum + "','" + ownerID + "','" 
                        + driverID+ "')";

                out.println("<!DOCTYPE html>");
                out.println("<html>\n"
                        + "    <head>\n"
                        + "        <link rel=\"icon\" type=\"image/ico\" href=\"img/favicon.ico\">\n"
                        + "                    <title>Confirm Details</title>"
                        + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "        <!-- Bootstrap -->\n"
                        + "        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                        + "        <!-- JQuery (necessary for Bootstrap's JavaScript plugins) -->\n"
                        + "        <!-- <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script> -->\n"
                        + "        <script src=\"js/bootstrap.min.js\"></script>\n"
                        + "    </head>\n"
                        + "    <body>\n"
                        + "        <ul class=\"nav nav-pills\">\n"
                        + "            <li role=\"presentation\"><a href=\"index.jsp\">Home</a></li>\n"
                        + "            <li role=\"presentation\"><a href=\"agreement.jsp\">Register Vehicle</a></li>\n"
                        + "            <li role=\"presentation\"><a href=\"viewDetails.jsp\">View Registered Vehicle</a></li>\n"
                        + "            <li role=\"presentation\"><a href=\"reports.jsp\">Reports</a></li>\n"
                        + "        </ul>");
                int sqlstatus = 0;
                if (cause == null || cause.trim().equals("")
                        || place == null || place.trim().equals("")
                        || date == null || date.trim().equals("")) {
                    // do nothing if empty
                }else {
                     sqlstatus = statement.executeUpdate(accidentsql);
                }
                if ((statement.executeUpdate(driversql) >= 0)
                        && (statement.executeUpdate(ownersql) >= 0)
                        && (statement.executeUpdate(vehiclesql) >= 0)
                        && sqlstatus >= 0) {
                    conn.commit();
                    out.println("<div class=\"alert alert-success\"><strong>Done!</strong>Record Successfully Saved</div>");
                } else {
                    conn.rollback();
                    out.println("<div class=\"alert alert-danger\"><strong>Error!</strong>Database Error with saving</div>"
                            + "<!--return to previous page-->\n" 
                            +"<button onclick=\"goBack()\">Go Back</button>"
                            + "<script>\n" 
                            + "  function goBack() {\n" 
                            + "     window.history.back();\n" 
                            + "   }\n" 
                            + "</script>");
                }
                
                out.println("</body>");
                out.println("</html>");
            } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex1);
            }
                out.println("Connection failed: " + ex.getMessage());
            } finally {
                out.close();
            }
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
        return "Short description";
    }// </editor-fold>

}
