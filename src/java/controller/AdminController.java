package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.JDBCBean;

//@author Nate
public class AdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get JDBC Bean
        JDBCBean bean = (JDBCBean) getServletContext().getAttribute("JDBCBean");
        
        //Find JSP that refered resource
        String requestingView = request.getParameter("viewId");
        getServletContext().log("Admin Controller received a request from " + requestingView);

        String include;
        switch (requestingView) {
            case "/ListMembers":
                getMember(bean, request, request.getParameter("selectedMember"));
                include = "/docs/ManageMember";
                break;
            case "/ListBalance":
                getMember(bean, request, request.getParameter("selectedMember"));
                include = "/docs/ManageMember";
                break;
            case "/ManageMember":
                suspendOrResumeMember(bean, request);
                include = "/docs/ManageMember";
                break;
                
                case "/ListClaims":
//                suspendOrResumeMember(bean, request);
                include = "/docs/ManageClaim";
                break;
            default:
                include = "/docs/error404.jsp";
        }

        request.getRequestDispatcher(include).forward(request, response);

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

    //Returns selected memebers details, including all claims and payments
    protected void getMember(JDBCBean bean, HttpServletRequest request, String requestedMemberID) {

        //Generate lists for required tables
        ArrayList requestedMember = new ArrayList();
        ArrayList requestedClaims = new ArrayList();
        ArrayList requestedPayments = new ArrayList();

        try {
            requestedMember = bean.sqlQueryToArrayList("SELECT * FROM members WHERE id='" + requestedMemberID + "'");
            requestedClaims = bean.sqlQueryToArrayList("SELECT * FROM claims WHERE mem_id='" + requestedMemberID + "'");
            requestedPayments = bean.sqlQueryToArrayList("SELECT * FROM payments WHERE mem_id='" + requestedMemberID + "'");
        } catch (SQLException ex) {
            System.out.println("SQL failed to execute in AdminController! " + ex);
        }

        request.setAttribute("requestedMember", requestedMember.get(0));
        request.setAttribute("requestedClaims", requestedClaims);
        request.setAttribute("requestedPayments", requestedPayments);
    }

    protected void suspendOrResumeMember(JDBCBean bean, HttpServletRequest request) {
        String action = request.getParameter("manageMemberAction").split("_")[0];
        String requestedMemberID = request.getParameter("manageMemberAction").split("_")[1];

        if (action.equalsIgnoreCase("suspend")) {
            bean.executeSQLUpdate("UPDATE members SET status='SUSPENDED' WHERE id='" + requestedMemberID + "'");
            bean.executeSQLUpdate("UPDATE users SET status='SUSPENDED' WHERE id='" + requestedMemberID + "'");
        } else if (action.equalsIgnoreCase("resume")) {
            bean.executeSQLUpdate("UPDATE members SET status='APPROVED' WHERE id='" + requestedMemberID + "'");
            bean.executeSQLUpdate("UPDATE users SET status='APPROVED' WHERE id='" + requestedMemberID + "'");
        }
        getMember(bean, request, requestedMemberID);
    }
}
