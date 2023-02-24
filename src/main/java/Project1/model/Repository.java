package Project1.model;

import Project1.logic.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcin
 */
public class Repository {  
    private Connection con = null;
    private String databaseResponse;
    
    public String connect(Transaction transaction) throws ClassNotFoundException, SQLException {
        try {
            //driver which integrates server with database
            Class.forName("com.mysql.jdbc.Driver");
            //connect with database
            con = DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/StudentBook","root","");  

            //executing transaction
            databaseResponse = transaction.execute(con);
        }
        catch (SQLException e) {
            throw new Error("Problem", e);
        }
        finally {
            try {
                if (con != null)
                    con.close(); //closing connection with database
            }
            catch (SQLException e) {
                throw new Error("Problem", e);
            }
        }
        return databaseResponse;
    }
}
