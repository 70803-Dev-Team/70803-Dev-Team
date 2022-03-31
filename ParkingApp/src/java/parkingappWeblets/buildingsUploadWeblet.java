/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package parkingappWeblets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.InputStream;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.FileOutputStream;
import parkingappcalculations.*;

// @author Sam Hildebrand
@WebServlet(name = "buildingsUploadWeblet", urlPatterns = {"/buildingsUploadWeblet"})
@MultipartConfig
public class buildingsUploadWeblet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<title>BuildingUpload</title>"); 
            DataBase db = DataBase.getInstance();
            try {
               Cookie cookies[] = request.getCookies(); 
                User currentUser = new User(cookies[0].getValue(), cookies[1].getValue());
                User dbUser = db.getUser(cookies[0].getValue());
                if(!dbUser.compareTo(currentUser)){
                   response.sendRedirect("index.html"); 
                } else {
                out.println("<form id=\"upload\" method=\"POST\" action=\"BFprocessingWeblet\" enctype=\"multipart/form-data\">\n" +
                    "<input type=\"file\" id=\"file\" name=\"file\" />\n" +
                    "<br/>\n" +
                    "<input type=\"submit\" id=\"uploadFile\" value=\"Upload\" />\n" +
                    "</form>");
                }
            } catch (Exception e){
                response.sendRedirect("index.html");
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
