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
                getMemberById(bean, request, request.getParameter("selectedMember"));
                include = "/docs/ManageMember";
                break;
            case "/ListBalance":
                getMemberById(bean, request, request.getParameter("selectedMember"));
                include = "/docs/ManageMember";
                break;
            case "/ManageMember":
                suspendOrResumeMember(bean, request);
                include = "/docs/ManageMember";
                break;

            case "/ListClaims":
                getClaim(bean, request, request.getParameter("selectedClaim"));
                getMemberByClaimId(bean, request, request.getParameter("selectedClaim"));
                include = "/docs/ManageClaim";
                break;
            case "/ManageClaim":
                acceptOrRejectClaim(bean, request);
                include = "/docs/ManageClaim";
                break;

            case "/ListApplications":
                getMemberById(bean, request, request.getParameter("selectedMember"));
                include = "/docs/ManageApplication";
                break;
            case "/ManageApplication":
                approveOrRejectApplication(bean, request);
                include = "/docs/ManageApplication";
                break;

            case "/ManageTurnover":
                getApprovedClaims(bean, request);
                include = "/docs/ManageApplication";
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
    protected void getMemberById(JDBCBean bean, HttpServletRequest request, String memberID) {

        //Generate lists for required tables
        ArrayList requestedMember = new ArrayList();
        ArrayList requestedClaims = new ArrayList();
        ArrayList requestedPayments = new ArrayList();

        try {
            requestedMember = bean.sqlQueryToArrayList("SELECT * FROM members WHERE id='" + memberID + "'");
            requestedClaims = bean.sqlQueryToArrayList("SELECT * FROM claims WHERE mem_id='" + memberID + "'");
            requestedPayments = bean.sqlQueryToArrayList("SELECT * FROM payments WHERE mem_id='" + memberID + "'");
        } catch (SQLException ex) {
            System.out.println("SQL failed to execute in AdminController! " + ex);
        }

        request.setAttribute("requestedMember", requestedMember.get(0));
        request.setAttribute("requestedClaims", requestedClaims);
        request.setAttribute("requestedPayments", requestedPayments);
    }

    //Returns member associated with claim ID provided
    protected void getMemberByClaimId(JDBCBean bean, HttpServletRequest request, String claimID) {

        //Get member ID
        String memberID = (String) getClaim(bean, request, claimID).get(1);

        //Generate lists for required tables
        ArrayList requestedMember = new ArrayList();
        ArrayList requestedClaims = new ArrayList();
        ArrayList requestedPayments = new ArrayList();

        try {
            requestedMember = (ArrayList) bean.sqlQueryToArrayList("SELECT * FROM members WHERE id='" + memberID + "'").get(0);
            requestedClaims = bean.sqlQueryToArrayList("SELECT * FROM claims WHERE mem_id='" + memberID + "'");
            requestedPayments = bean.sqlQueryToArrayList("SELECT * FROM payments WHERE mem_id='" + memberID + "'");
        } catch (SQLException ex) {
            System.out.println("SQL failed to execute in AdminController! " + ex);
        }

        request.setAttribute("requestedMember", requestedMember);
        request.setAttribute("requestedClaims", requestedClaims);
        request.setAttribute("requestedPayments", requestedPayments);
    }

    //Gets selected claim by ID
    protected ArrayList getClaim(JDBCBean bean, HttpServletRequest request, String claimID) {

        //Get selected claim
        ArrayList claim = new ArrayList();

        try {
            claim = (ArrayList) bean.sqlQueryToArrayList("SELECT * FROM claims WHERE id='" + claimID + "'").get(0);
        } catch (SQLException ex) {
            System.out.println("SQL failed to execute in AdminController! " + ex);
        }

        request.setAttribute("requestedClaim", claim);

        return claim;
    }

    //Get all approved claims
    protected void getApprovedClaims(JDBCBean bean, HttpServletRequest request) {
        
        //Get all approved  claims
        ArrayList approvedClaims = new ArrayList();

        try {
            approvedClaims = (ArrayList) bean.sqlQueryToArrayList("SELECT * FROM claims WHERE status='APPROVED'");
        } catch (SQLException ex) {
            System.out.println("SQL failed to execute in AdminController! " + ex);
        }

        request.setAttribute("approvedClaims", approvedClaims);
    }

    //Sets status of members account
    protected void suspendOrResumeMember(JDBCBean bean, HttpServletRequest request) {
        
        //Split into action and member ID
        String action = request.getParameter("manageMemberAction").split("_")[0];
        String memberID = request.getParameter("manageMemberAction").split("_")[1];

        if (action.equalsIgnoreCase("suspend")) {
            bean.executeSQLUpdate("UPDATE members SET status='SUSPENDED' WHERE id='" + memberID + "'");
            bean.executeSQLUpdate("UPDATE users SET status='SUSPENDED' WHERE id='" + memberID + "'");
        } else if (action.equalsIgnoreCase("resume")) {
            bean.executeSQLUpdate("UPDATE members SET status='APPROVED' WHERE id='" + memberID + "'");
            bean.executeSQLUpdate("UPDATE users SET status='APPROVED' WHERE id='" + memberID + "'");
        }
        getMemberById(bean, request, memberID);
    }

    //Upgrades provisional memeber to full member or rejects application
    protected void approveOrRejectApplication(JDBCBean bean, HttpServletRequest request) {
        
        //Split into action and member ID
        String action = request.getParameter("manageMemberAction").split("_")[0];
        String memberID = request.getParameter("manageMemberAction").split("_")[1];

        if (action.equalsIgnoreCase("approve")) {
            bean.executeSQLUpdate("UPDATE members SET status='APPROVED' WHERE id='" + memberID + "'");
            bean.executeSQLUpdate("UPDATE users SET status='APPROVED' WHERE id='" + memberID + "'");
            bean.executeSQLUpdate("UPDATE members SET balance=balance - " + 10.0 + " WHERE id='" + memberID + "'");
        } else if (action.equalsIgnoreCase("reject")) {
            bean.executeSQLUpdate("UPDATE members SET status='REJECTED' WHERE id='" + memberID + "'");
            bean.executeSQLUpdate("UPDATE users SET status='REJECTED' WHERE id='" + memberID + "'");
        }

        getMemberById(bean, request, memberID);
    }

    //Sets status of selected claim
    protected void acceptOrRejectClaim(JDBCBean bean, HttpServletRequest request) {
        
        //Split into action and claim ID
        String action = request.getParameter("manageClaimAction").split("_")[0];
        String claimID = request.getParameter("manageClaimAction").split("_")[1];

        if (action.equalsIgnoreCase("accept")) {
            bean.executeSQLUpdate("UPDATE claims SET status='APPROVED' WHERE id='" + claimID + "'");
        } else if (action.equalsIgnoreCase("reject")) {
            bean.executeSQLUpdate("UPDATE claims SET status='REJECTED' WHERE id='" + claimID + "'");
        }
        getMemberByClaimId(bean, request, claimID);
    }

    //Calculate sum of claims approved
    
    //Charge members yearly fee
}
