package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.JDBCBean;
import model.LoginBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Susan Rai
 * @author Sundas Choudry
 */

public class Login extends HttpServlet {

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
        JDBCBean bean = (JDBCBean) getServletContext().getAttribute("JDBCBean");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResultSet resultSet = null;
//        LoginBean loginBean = new LoginBean();
        String idQuery = "";
        String passwordQuery = "";
        String statusQuery = "";
        String errorMessage = "";
        boolean loginValidation = false;
        HttpSession session = request.getSession();

        // Set username and password 
//        loginBean.setUsername(username);
//        loginBean.setPassword(password);
        try {
            resultSet = bean.executeSQLQuery("SELECT id,password,status FROM users");

            // Checks if the getUsername or password is empty 
            if (username == null || password == null || username.length() == 0 || password.length() == 0) {
                loginValidation = true;
                errorMessage = "Username and password is required";
            } else {
                // Iterate through Databases to check if ID and password provide by the user match
                while (resultSet.next()) {
                    idQuery = resultSet.getString("id");
                    passwordQuery = resultSet.getString("password");
                    statusQuery = resultSet.getString("status");

                    if (username.equals(idQuery) && password.equals(passwordQuery)) {
                        loginValidation = false;
                        break;
                    } else {
                        loginValidation = true;
                        errorMessage = "Invalid Login details";
                    }
                }
            }

            // If user provides incorrect information, load the login page again
            if (loginValidation) {
                request.setAttribute("ErrorMessage", errorMessage);
                RequestDispatcher view = request.getRequestDispatcher("/docs/Login");
                view.forward(request, response);
            } else{
                if (statusQuery.equals("ADMIN")) {
                //Making it thread safe
                synchronized (session) {
                    // Store user info in Session
                    session.setAttribute("adminUsername", username);
                }
                Cookie userID = new Cookie("username", username);
                //Store user info in Cookie
                response.addCookie(userID);

                response.sendRedirect(request.getContextPath() + "/docs/AdminDashboard");
            } else {
                //Making it thread safe
                synchronized (session) {
                    // Store user info in Session
                    session.setAttribute("username", username);
                }
                //Session will expire in 20 mins
                session.setMaxInactiveInterval(20 * 60);
                Cookie userID = new Cookie("username", username);
                //Store user info in Cookie
                response.addCookie(userID);
                // If the user cookie is disabled
                //String encodedURL = response.encodeRedirectURL("/userDash");
                /* If a POST is been successful, you normally want to redirect the request, so that the request 
                    won't be resubmitted when the user refreshes the request (e.g. pressing F5 or navigating back in history). */
                response.sendRedirect(request.getContextPath() + "/userDash");
            }
        }

            resultSet.close();
        } catch (SQLException ex) {

            System.out.println("SQL statement failed executed!");
            ex.printStackTrace();
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
