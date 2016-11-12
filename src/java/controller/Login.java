/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.JDBCBean;
import model.LoginBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
        String id = request.getParameter("ID");
        String password = request.getParameter("password");
        ResultSet resultSet = null;
        LoginBean loginBean = new LoginBean();
        String idQuery = "";
        String passwordQuery = "";
        String statusQuery = "";
        boolean loginValidation = false;

        loginBean.setID(id);
        loginBean.setPassword(password);
        try {
            resultSet = bean.executeSQLQuery("SELECT id,password,status FROM users");

            while (resultSet.next()) {
                idQuery = resultSet.getString("id");
                passwordQuery = resultSet.getString("password");
                statusQuery = resultSet.getString("status");

                if (loginBean.getID().equals(idQuery) && loginBean.getPassword().equals(passwordQuery)) {
                    loginValidation = true;
                    break;
                }
            }

            if (loginValidation) {
                if (statusQuery.equals("ADMIN")) {
                    request.setAttribute("ID", id);
                    RequestDispatcher view = request.getRequestDispatcher("/docs/AdminDashboard");
                    view.forward(request, response);
                } else {
                    /* Code to do it without session
                    request.setAttribute("ID", id);
                    RequestDispatcher view = request.getRequestDispatcher("/docs/UserDashboard");
                    view.forward(request, response);*/
                    HttpSession session = request.getSession();
                    session.setAttribute("ID", id);
                    //Session will expiry in 20 mins
                    session.setMaxInactiveInterval(20 * 60);
                    Cookie userID = new Cookie("ID", id);
                    response.addCookie(userID);
                    String encodedURL = response.encodeRedirectURL("secure/user/UserDashboard.jsp");
                    response.sendRedirect(encodedURL);
                }
            } else {
                request.setAttribute("ErrorMessage", "Invalid Login");
                RequestDispatcher view = request.getRequestDispatcher("/docs/Login");
                view.forward(request, response);
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
