/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package na.edu.nust.nabta;

import java.io.IOException;
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
@WebServlet(name = "Data2", urlPatterns = {"/Data2"})
public class Data2 extends HttpServlet {

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
        
        // request the parameters from the data1 page
        String ownerNames = request.getParameter("ownerNames");
        String ownerSurname = request.getParameter("ownerSurname");
        String driverNames = request.getParameter("driverNames");
        String driverSurname = request.getParameter("driverSurname");
        String regNum = request.getParameter("regNum");
        String nbtaID = request.getParameter("nbtaID");
        String type = request.getParameter("type");
        String model = request.getParameter("model");
        String mass = request.getParameter("mass");
        String color = request.getParameter("color");
        String cause = request.getParameter("cause");
        String place = request.getParameter("place");
        String date = request.getParameter("date");

        //create the session object
        // get the user's session object
        // don't create session if one does exist
        HttpSession ses = request.getSession(true);
        if (ses.isNew()) {
            response.sendRedirect("agreement.jsp");
        } // if user submit blank parameters or null send the user back to index page
        else if (ownerNames == null || ownerNames.trim().equals("") ||ownerSurname == null || ownerSurname.trim().equals("") 
                || driverNames == null || driverNames.trim().equals("") || driverSurname == null || driverSurname.trim().equals("")
                || regNum == null || regNum.trim().equals("") || nbtaID == null || nbtaID.trim().equals("")
                || model == null || model.trim().equals("") || mass == null || mass.trim().equals("")
                || color == null || color.trim().equals("")) {
            response.sendRedirect("data1.jsp");
        } else {
            //if the user is not new, set the parameters to the session and send user to registration servlet
            ses.setAttribute("ownerNames", ownerNames);
            ses.setAttribute("ownerSurname", ownerSurname);
            ses.setAttribute("driverNames", driverNames);
            ses.setAttribute("driverSurname", driverSurname);
            ses.setAttribute("regNum", regNum);
            ses.setAttribute("nbtaID", nbtaID);
            ses.setAttribute("type", type);
            ses.setAttribute("model", model);
            ses.setAttribute("mass", mass);
            ses.setAttribute("color", color);
            ses.setAttribute("cause", cause);
            ses.setAttribute("place", place);
            ses.setAttribute("date", date);
            // set registration fee depending on vehicle type
            if (type.trim().equals("Taxi")) {
                ses.setAttribute("fees", "1500");
            } else if (type.trim().equals("Minibus")) {
                ses.setAttribute("fees", "2500");
            } else if (type.trim().equals("Bus")) {
                ses.setAttribute("fees", "3500");
            }
            response.sendRedirect("data2.jsp");
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
        return "Process form  data";
    }// </editor-fold>

}
