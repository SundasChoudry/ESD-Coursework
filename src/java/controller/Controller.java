package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        //Get session attribute
        HttpSession session = request.getSession();

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

            //Login
            case "/docs/Login":
                include = "Login.jsp";
                break;

            //Registration
            case "/docs/Registration":
                include = "Registration.jsp";
                break;

            //Admin
            case "/docs/AdminDashboard":
                // Check if session is still valid
                if (session.getAttribute("adminUsername") == null) {
                    include = "Login.jsp";
                } else {
                    include = "AdminDashboard.jsp";
                }
                break;

            case "/docs/ListMembers":
                include = "ListMembers.jsp";
                break;
            case "/docs/ListBalance":
                include = "ListBalance.jsp";
                break;
            case "/docs/ManageMember":
                include = "ManageMember.jsp";
                break;
            case "/docs/ListClaims":
                include = "ListClaims.jsp";
                break;
            case "/docs/ManageClaim":
                include = "ManageClaim.jsp";
                break;
            case "/docs/ListApplications":
                include = "ListApplications.jsp";
                break;
            case "/docs/ManageApplication":
                include = "ManageApplication.jsp";
                break;
            case "/docs/ManageTurnover":
                include = "ManageTurnover.jsp";
                break;
                
            //Users
            case "/docs/UserDashboard":
                // Check if session is still valid
                if (session.getAttribute("username") == null) {
                    include = "Login.jsp";
                } else {
                    include = "UserDashboard.jsp";
                }
                break;

            case "/docs/ManageUserBalance":
                include = "ManageUserBalance.jsp";
                break;

            case "/docs/UserBalance":
                include = "UserBalance.jsp";
                break;

            case "/docs/UserMakeClaim":
                include = "UserClaimForm.jsp";
                break;

            case "/docs/UserClaimConfirm":
                include = "UserClaimConfirm.jsp";
                break;

            case "/docs/UserMakePayment":
                include = "UserPaymentForm.jsp";
                break;

            case "/docs/UserPaymentConfirm":
                include = "UserPaymentConfirm.jsp";
                break;
            default:
                include = "/docs/Error404.jsp";
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
