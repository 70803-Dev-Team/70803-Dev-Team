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
@WebServlet(name = "AccountRegistration", urlPatterns = {"/AccountRegistration"})
public class AccountRegistration extends HttpServlet {
    
    private String displayLoginForm(String errorMessage){
         return ("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial scale=1.0\">\n" +
                    "    <title>LSU Parking Assistant</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                    "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                    "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                    "    <link href=\"https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;600;700&display=swap\" \n" +
                    "    rel=\"stylesheet\">\n" +
                    "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <!-----Website Header----->\n" +
                    "    <!-----NO HEADER FOR THIS PAGE----->\n" +
                    "    \n" +
                    "    <!-----Create Account Form----->\n" +
                    "    <div class=\"background-img\">\n" +
                    "        <div class=\"content\">\n" +
                    "            <header>Create Account</header>\n" +
                    "            <form action=\"AccountRegistration\">\n" +
                    "             <h2>" +
                                    errorMessage +
                    "             </h2>" +
                    "                <div class=\"field space\">\n" +
                    "                    <input type=\"text2\" class=\"name\" placeholder=\"First Name\">\n" +
                    "                </div>\n" +
                    "                <div class=\"field space\">\n" +
                    "                    <input type=\"text2\"class=\"name\" placeholder=\"Last Name\">\n" +
                    "                </div>\n" +
                    "                <div class=\"field space\">\n" +
                    "                    <input type=\"text2\" class=\"email\" name=\"userName\" required placeholder=\"Email Address\">\n" +
                    "                </div>\n" +
                    "                <div class=\"field space\">\n" +
                    "                    <input type=\"text2\" class=\"phone\" placeholder=\"Phone Number\">\n" +
                    "                </div>\n" +
                    "                <div class=\"field space\">\n" +
                    "                    <input type=\"password\" class=\"password\" name=\"password1\" required placeholder=\"Password\">\n" +
                    "                </div>\n" +
                    "                <div class=\"field space\">\n" +
                    "                    <input type=\"password\" class=\"password\" name=\"password2\" required placeholder=\"Re-type Password\">\n" +
                    "                </div>\n" +
                    "                \n" +
                    "                <div class=\"pass\"></div>\n" +
                    "                <div class=\"field\">\n" +
                    "                    <input type=\"submit\" class=\"button\" value=\"Create Account\">\n" +
                    "                    \n" +
                    "                </div>\n" +
                    "            </form>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "\n" +
                    "\n" +
                    "<!-----Website Footer----->\n" +
                    "    <section class=\"footer\">\n" +
                    "        <div class=\"icons\">\n" +
                    "            <i class=\"fa fa-facebook\"></i>\n" +
                    "            <i class=\"fa fa-twitter\"></i>\n" +
                    "            <i class=\"fa fa-instagram\"></i>\n" +
                    "            <i class=\"fa fa-linkedin\"></i>\n" +
                    "        </div>\n" +
                    "        <p><i class=\"fa fa-copyright\"></i>2022 70803 Dev Team, Inc. All Rights Reserved</p>\n" +
                    "    </section>\n" +
                    "</body>\n" +
                    "</html>");
    }

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
        DataBase db = DataBase.getInstance();
        try {
            Cookie cookies[] = request.getCookies(); 
            User currentUser = new User(cookies[0].getValue(), cookies[1].getValue());
            User dbUser = db.getUser(cookies[0].getValue());
            if(!dbUser.compareTo(currentUser)){
               response.sendRedirect("index.html"); 
            }
        } catch (Exception e){
            response.sendRedirect("index.html");
        }
        try ( PrintWriter out = response.getWriter()) {
            out.println(displayLoginForm(""));
            String userName = request.getParameter("userName");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            if (password1.equals(password2)){
                User newUser = new User(userName, password1);
                User databaseUser = db.getUser(userName);
                if (databaseUser != null){
                    out.println(displayLoginForm("Username Already Taken"));
                } else {
                    db.addUser(userName, password1);
                    response.sendRedirect("Login?userName=" + userName + "&password=" + password1);
                }
                
            } else {
                out.println(displayLoginForm("Password retyped incorrectly"));
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
