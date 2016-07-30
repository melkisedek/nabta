/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package na.edu.nust.nabta;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Confirm", urlPatterns = {"/Confirm"})
public class Confirm extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        try {
            //create the session object
            // get the user's session object
            // don't create session if one does exist
            HttpSession ses = request.getSession(true);

            // request the attributes from the Session
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

            //// request the parameters from the data2 page
            String ownerID = request.getParameter("ownerID");
            String driverID = request.getParameter("driverID");
            String postAddr = request.getParameter("postAddr");
            String residentAddr = request.getParameter("residentAddr");
            String region = request.getParameter("region");

            // save parameters to the session
            ses.setAttribute("ownerID", ownerID);
            ses.setAttribute("driverID", driverID);
            ses.setAttribute("postAddr", postAddr);
            ses.setAttribute("residentAddr", residentAddr);
            ses.setAttribute("region", region);

            if (ses.isNew()) {
                response.sendRedirect("agreement.jsp");
            } else {
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
                        + "        </ul>"
                        + "<h3>Confirm Details</h3>"
                        + "<p>Please confirm your details below.</p>");

                // display the gathered information
                out.println("<ul><li>Owner's full name: " + ownerNames + " " + ownerSurname + "</li>"
                        + "<li>Owner's ID number: " + ownerID + "</li>"
                        + "<li>Driver's full name: " + driverNames + " " + driverSurname + "</li>"
                        + "<li>Driver's ID number: " + driverID + "</li>"
                        + "<li>Postal Address: " + postAddr + "</li>"
                        + "<li>Residential Address: " + residentAddr + "</li>"
                        + "<li>Region: " + region + "</li>"
                        + "<li>Registration number: " + regNum + "</li>"
                        + "<liNABTA ID: " + nbtaID + "</li>"
                        + "<li>Type: " + type + "</li>"
                        + "<li>Registration Fees: N$ " + fees + ".00</li>"
                        + "<li>Model: " + model + "</li>"
                        + "<li>Mass: " + mass + "</li>"
                        + "<li>Color: " + color + "</li>");
                out.println("<p>Place, date and cause of accident if any.<p>"
                        + "<li>Cause: " + cause + "</li>"
                        + "<li>Place: " + place + "</li>"
                        + "<li>Date: " + date + "</li></ul>");
                out.println("    <form action=\"Register\" method=\"POST\">\n"
                        + "        <table border=\"0\">\n"
                        + "            <tbody>\n"
                        + "                <tr>\n"
                        + "                    <td><p><a href='index.jsp'><input type=\"button\" value=\"CANCEL\" /></a></p></td>"
                        + "                    <td><input class=\"btn btn-default\" type=\"submit\" value=\"Confirm\" /></td>"
                        + "                </tr>"
                        + "            </tbody>"
                        + "        </table>"
                        + "    </form>");   // confirm link to Registration Servlet/
                out.println("</body>");
                out.println("</html>");
            }
        } finally {
            out.close();
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
        return "Show confirmation";
    }// </editor-fold>

}
