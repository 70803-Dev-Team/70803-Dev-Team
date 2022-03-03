package parkingapp;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @author Sam Hildebrand
@WebServlet(name = "RateLot", urlPatterns = {"/RateLot"})
public class RateLot extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            out.println("<title>Rate Lots</title>"); 
            Cookie cookies[] = request.getCookies();
            DataBase db = new DataBase();
            User currentUser = new User(cookies[0].getValue(), cookies[1].getValue());
            User dbUser = db.getUser(cookies[0].getValue());
            if (dbUser.compareTo(currentUser)){
                out.println("<!DOCTYPE html><html><head>");            
                out.println("</head><body>");
                out.println("<html><body><a href=\"ParkingApp\">Find Parking</a><form action=\"RateLot\" method=\"get\">Lot: <input type=\"text\" name=\"lotName\"> Fullness (1-5): <input type=\"text\" name=\"rating\"><br><input type=\"submit\" value=\"go\"><br>");
                String rating = request.getParameter("rating");
                String lotName = request.getParameter("lotName");
                db.storeRating(lotName, cookies[0].getValue(), rating);
                out.println("</body></html>");
            } else {
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
