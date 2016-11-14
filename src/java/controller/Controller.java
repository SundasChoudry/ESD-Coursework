package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.JDBCBean;

//@author Nate
@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/docs/*"})
public class Controller extends HttpServlet {

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
        //Get JDBCBean from context
        JDBCBean bean = (JDBCBean) getServletContext().getAttribute("JDBCBean");
        //Always Forward to main.jsp
        String mainPage = "/WEB-INF/docs/main.jsp";

        //Find requested resource
        String requestPath = request.getRequestURI().substring(request.getContextPath().length());

        getServletContext().log("Controller received a request for " + requestPath);

        //Resource to include
        String include;
        switch (requestPath) {

            case "/Controller":
                include = "mainStart.jsp";
                break;

            //Admin
            case "/docs/AdminDashboard":
                include = "AdminDashboard.jsp";
                break;

            case "/docs/MembersList":
                //Execute sql statement
                bean.executeSQLQuery("SELECT * FROM members");

                ArrayList retreivedMembers = new ArrayList();
                try {
                    retreivedMembers = bean.resultsToArrayList();
                } catch (SQLException e) {
                    System.out.println("SQL Statement Not Executed...\n" + e.toString() + "\n");
                }

                request.setAttribute("membersList", retreivedMembers);
                include = "MembersList.jsp";
                break;

            //Users
            case "/docs/UserDashboard":
                include = "UserDashboard.jsp";
                break;

            //Login
            case "/docs/Login":
                include = "Login.jsp";
                break;

            //Login
            case "/docs/Registration":
                include = "Registration.jsp";
                break;

            default:
                include = "/docs/error404.jsp";
        }
        request.setAttribute("included", include);

        request.getRequestDispatcher(mainPage).forward(request, response);
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
