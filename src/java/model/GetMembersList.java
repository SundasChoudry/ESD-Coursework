package model;

// @author Nate
import java.sql.SQLException;
import java.util.ArrayList;

public class GetMembersList {

    //Variables
    private JDBCBean bean;
    private String sqlStatement = "SELECT * FROM members";

    //Constructors   
    public GetMembersList(JDBCBean bean) {
        this.bean = bean;
    }

    //Methods
    public ArrayList getMembers() {
        //Execute sql statement
        bean.executeSQLQuery(sqlStatement);

        ArrayList retreivedMembers = new ArrayList();
        try {
            retreivedMembers = bean.resultsToArrayList();
////////////
            for (int i = 0; i < retreivedMembers.size(); i++) {
                ArrayList mem = (ArrayList) retreivedMembers.get(i);
                System.out.println(mem.getClass());
                for (Object member : mem) {
                    System.out.println(member.toString());
                    System.out.println(member.getClass());
                    System.out.println("NOn");
                }

            }
            ///////
        } catch (SQLException e) {
            System.out.println("SQL Statement Not Executed...\n" + e.toString() + "\n");
        }
        return retreivedMembers;
    }
}//End GetMembersList
