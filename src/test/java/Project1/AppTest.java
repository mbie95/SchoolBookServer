package Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class AppTest 
{
    Connection con = null;
    
    @Before
    public void createDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/StudentBook","root","");  
    }

    @Test
    public void greetingsMethodTest_StringsShouldBeSame() {
        assertThat(App.greetings("Hello World!"), is("Hello World!"));
    }
    
    @Test
    public void preparedStatementUpdateTest_UpdatedRowEqualToOne() throws SQLException, ParseException {
        PreparedStatement preparedStmt = null;
        String query = "INSERT INTO `Students`(`first_name`, `last_name`, "
                        + "`birth_date`, `street_and_number`, `post_code`, `city`, `class_number`, `password`) "
                        + "VALUES (?,?,?,?,?,?,?,?)";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, "Seweryn");
        preparedStmt.setString(2, "Nicinski");
        String dateString = "2007-08-21";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateString);
        preparedStmt.setDate(3, new java.sql.Date(date.getTime()));
        preparedStmt.setString(4, "Polna 32");
        preparedStmt.setString(5, "65-345");
        preparedStmt.setString(6, "Nowe Miasto");
        preparedStmt.setString(7, "7a");
        preparedStmt.setString(8, "testpass");
        
        int n = preparedStmt.executeUpdate();
        assertThat(n, is(1));
        
        preparedStmt.close();
    }
    
    @Test
    public void preparedStatementGetTest_AllShouldBeSame() throws SQLException, ParseException {
        PreparedStatement preparedStmt = null;
        String query = "SELECT last_name, birth_date FROM Students "
                + "WHERE class_number = '7a'";
        preparedStmt = con.prepareStatement(query);
        
        ResultSet rs = preparedStmt.executeQuery();

        while(rs.next()) {
            assertThat(rs.getString("last_name"), is("Nicinski"));
            assertThat(rs.getString("birth_date"), is("2007-08-21"));
        }
        
        preparedStmt.close();
    }
    
    @After
    public void shutdownDatabase() throws SQLException {
        con.close();
    }
    
}
