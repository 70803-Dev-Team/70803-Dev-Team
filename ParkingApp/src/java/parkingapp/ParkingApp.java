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
@WebServlet(name = "ParkingApp", urlPatterns = {"/ParkingApp"})
public class ParkingApp extends HttpServlet {

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
            out.println("<title>ParkingApp</title>");  
            // Anytime we have a webapp java file like this one, we need to check
            // that the user is actually valid. So we check the cookies and test
            // the user against the one in the database like so.
            Cookie cookies[] = request.getCookies();
            DataBase db = new DataBase();
            User currentUser = new User(cookies[0].getValue(), cookies[1].getValue());
            User dbUser = db.getUser(cookies[0].getValue());
            if (dbUser.compareTo(currentUser)){
                out.println("<html><body>"
                        + "<a href=\"RateLot\">Rate Lots</a>"
                        + "<form action=\"ParkingApp\" method=\"get\">"
                        + "Enter the building you are looking for: "
                        + "<input type=\"text\" name=\"buildingName\"><br>"
                        + "<input type=\"submit\" value=\"go\"><br>");
                String buildingName = request.getParameter("buildingName");
                Suggestion suggestion = db.getSuggestion(buildingName);
                out.println(suggestion.toArray());
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
