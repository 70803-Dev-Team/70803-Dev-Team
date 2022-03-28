package parkingappWeblets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import parkingappcalculations.*;

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
            DataBase db = DataBase.getInstance();
            User currentUser = new User(cookies[0].getValue(), cookies[1].getValue());
            User dbUser = db.getUser(cookies[0].getValue());
            if (dbUser.compareTo(currentUser)){
                out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial scale=1.0\">\n" +
                "    <title>ParkingApp</title>\n" +
                "    <link rel=\"stylesheet\" href=\"style_map.css\">\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;600;700&display=swap\" \n" +
                "    rel=\"stylesheet\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "    <script src='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.js'></script>\n" +
                "    <link href='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.css' rel='stylesheet' />\n" +
                "\n" +
                "    <script src=\"script.js\" defer></script>\n" +
                "</head>\n" +
                "    <body>\n" +
                "        <div class=\"main_box\"></div>\n" +
                "        <header tabindex=\"0\">LSU Parking Assistant</header>\n" +
                "        <div id=\"nav-container\">\n" +
                "            <div class=\"bg\"></div>\n" +
                "            <div class=\"button\" tabindex=\"0\">\n" +
                "              <span class=\"icon-bar\"></span>\n" +
                "              <span class=\"icon-bar\"></span>\n" +
                "              <span class=\"icon-bar\"></span>\n" +
                "            </div>\n" +
                "            <div id=\"nav-content\" tabindex=\"0\">\n" +
                "              <ul>\n" +
                "                <li><a href=\"#\">General Settings</a></li>\n" +
                "                <li><a href=\"#\">Account Settings</a></li>\n" +
                "                <li><a href=\"#\">Help Center</a></li>\n" +
                "                <li><a href=\"https://github.com/70803-Dev-Team/70803-Dev-Team/issues\">Report an issue</a></li>\n" +
                "                <li><a href=\"#\">Log out</a></li>\n" +
                "                <li class=\"small\"><i class=\"fa fa-copyright\"></i>2022 70803 Dev Team, Inc. All Rights Reserved</a></li>\n" +
                "              </ul>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "            <div id=\"directionsOverlay\">\n" +
                "                <h1>Directions</h1>\n" +
                "                <form action=\"LotSugestions\" method=\"get\">\n" +
                "                    <p class=\"form_group\">\n" +
                "                        <input type=\"input\" class=\"form_field\" placeholder=\"Building you want to go to\" name=\"buildingName\">\n" +
                "                        <label for=\"name\" class=\"form_label\">Building you want to go to</label>\n" +
                "                    </p>\n" +
                "                <p class=\"field\">\n" +
                "                    <input type=\"submit\" value=\"Go!\">\n" +
                "                </p>\n" +
                "                </form> \n" +
                "                <p class=\"rateLot\">\n" +
                "                    <a href=\"RateLot\">Rate a Parking Lot</a>\n" +
                "                </p>\n" +
                "            \n" +
                "\n" +
                "                <!-----Side Bar Menu----->\n" +
                "                \n" +
                "                    \n" +
                "\n" +
                "                \n" +
                "            </div>\n" +
                "        </div>  \n" +
                "        <div id='map'></div>\n" +
                "    </body>\n" +
                "</html>");
                String buildingName = request.getParameter("buildingName");
                Suggestion suggestion = db.getSuggestion(buildingName);
                //out.println(suggestion.toArray());
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
