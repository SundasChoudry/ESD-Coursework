/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.JDBCBean;

/**
 *
 * @author Tom Fisher
 */
public class UserController extends HttpServlet {

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
        HttpSession session = request.getSession();

        // Check if session is still valid
//        if (session.getAttribute("username") == null) {
//            RequestDispatcher view = request.getRequestDispatcher("/docs/Login");
//            view.forward(request, response);
//        }

        JDBCBean bean = (JDBCBean) getServletContext().getAttribute("JDBCBean");

        //Find JSP that refered resource
        String requestingView = request.getParameter("viewId");
        getServletContext().log("User Controller received a request from " + requestingView);

        String include;
        switch (requestingView) {
            case "/UserBalance":
                getBalance(bean, request);
                include = "/docs/user/UserBalance";
                break;
            case "/UserMakeClaim":
                makeClaim(bean, request);
                include = "/docs/user/UserClaimConfirm";
                break;
            case "/UserMakePayment":
                makePayment(bean, request);
                include = "/docs/user/UserPaymentConfirm";
                break;
            default:
                include = "/docs/user/error404.jsp";
        }

        request.getRequestDispatcher(include).forward(request, response);

        // Store info in request attribute
        // request.setAttribute("user", username);
        // Logined, forward to /WEB-INF/views/userInfoView.jsp
        //RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/docs/UserDashboard");
        //RequestDispatcher view = request.getRequestDispatcher("/docs/UserDashboard");
        //view.forward(request, response);
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

    public void getBalance(JDBCBean bean, HttpServletRequest request) {
        String username = request.getParameter("username");
        ArrayList balance = new ArrayList();
        try {
            balance = bean.sqlQueryToArrayList("SELECT balance FROM `Members` WHERE id='" + username + "'");
            request.setAttribute("balance", balance);
        } catch (SQLException ex) {
            System.out.println("SQL failed to execute in UserController, getBalance! " + ex);
        }

    }

    private void makeClaim(JDBCBean bean, HttpServletRequest request) {
        ArrayList temp;
        String user = request.getParameter("username");
        String rationale = request.getParameter("rationale");
        double amount = Double.parseDouble(request.getParameter("amount"));
        try {
            temp = getRowNum(bean, "id", "Claims");
            bean.executeSQLUpdate("INSERT INTO `Claims`(`id`, `mem_id`, `date`, `rationale`, `status`, `amount`) "
                    + "VALUES (" + ((long) temp.get(0) + 1) + ",'" + user + "','" + new java.sql.Date(Calendar.getInstance().getTime().getTime()) + "','" + rationale + "'," + "'SUBMITTED'" + "," + amount + ")");
            request.setAttribute("confirm", "succeeded");
        } catch (SQLException ex) {
            request.setAttribute("confirm", "failed");
            System.out.println("SQL failed to execute in UserController, makeClaim! " + ex);
        }
    }

    public ArrayList getRowNum(JDBCBean bean, String column, String table) throws SQLException {
        return (ArrayList) bean.sqlQueryToArrayList("SELECT COUNT(" + column + ") FROM " + table).get(0);
    }

    public void makePayment(JDBCBean bean, HttpServletRequest request) {
        ArrayList temp;
        String user = request.getParameter("username");
        String paymentType = request.getParameter("paymentType");
        double amount = Double.parseDouble(request.getParameter("amount"));
        try {
            temp = getRowNum(bean, "id", "payments");
            bean.executeSQLUpdate("INSERT INTO `payments`(`id`, `mem_id`, `type_of_payment`, `amount`, `date`) "
                    + "VALUES (" + ((long) temp.get(0) + 1) + ",'" + user + "','" + paymentType + "'," + amount + ",'" + new java.sql.Date(Calendar.getInstance().getTime().getTime()) + "')");
            request.setAttribute("confirm", "succeeded");
        } catch (SQLException ex) {
            request.setAttribute("confirm", "failed");
            System.out.println("SQL failed to execute in UserController, makePayment! " + ex);
        }
    }

}
