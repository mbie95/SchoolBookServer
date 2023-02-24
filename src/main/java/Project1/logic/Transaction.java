package Project1.logic;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author marcin
 */
//making requests to database
public class Transaction {
    private RequestType transactionType; //typ zapytania, jego zadanie
    private ArrayList<String> args; //przechowywane sa dane do zapytania
    private PreparedStatement preparedStmt = null;
    private String query;
    private String returningData = "";
    private ResultSet rs;
    private String passSalted, passSHA1;
    private MessageDigest sha1;
    
    Transaction(RequestType transactionType, ArrayList<String> args) {
        this.transactionType = transactionType;
        this.args = new ArrayList<>(args);
    }
    
    public RequestType getTransactionType() {
        return transactionType;
    }
    
    public String execute(Connection con) throws SQLException {
        try {
            switch (this.transactionType) {
                case GET_STUDENT_BY_ID:
                    query = "CALL getStudentById(?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    rs = preparedStmt.executeQuery();
                    while(rs.next())
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i)
                            returningData += rs.getString(i) + ";";
                    break;
                case CHANGE_STUDENT_ADDRESS:
                    query = "CALL changeStudentAddress(?,?,?,?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    preparedStmt.setString(2, args.get(1));
                    preparedStmt.setString(3, args.get(2));
                    preparedStmt.setString(4, args.get(3));
                    returningData = ";" + preparedStmt.executeUpdate();
                    break;
                case GET_STUDENT_GRADES:
                    query = "CALL getAllMyGrades(?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    rs = preparedStmt.executeQuery();
                    while(rs.next()) {
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i)
                            returningData += rs.getString(i) + ";";
                        returningData += '*';
                    }
                    break;
                case GET_STUDENT_GRADE_FROM:
                    query = "CALL getMyGradeFrom(?,?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    preparedStmt.setInt(2, Integer.parseInt(args.get(1)));
                    rs = preparedStmt.executeQuery();
                    while(rs.next()) {
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i)
                            returningData += rs.getString(i) + ";";
                    }
                    break;
                case GET_TEACHER_BY_ID:
                    query = "CALL getTeacherById(?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    rs = preparedStmt.executeQuery();
                    while(rs.next())
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i)
                            returningData += rs.getString(i) + ";";
                    break;
                case CHANGE_TEACHER_ADDRESS:
                    query = "CALL changeTeacherAddress(?,?,?,?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    preparedStmt.setString(2, args.get(1));
                    preparedStmt.setString(3, args.get(2));
                    preparedStmt.setString(4, args.get(3));
                    returningData = ";" + preparedStmt.executeUpdate();
                    break;
                case GET_TEACHER_ALL_HIS_STUDENTS_GRADES:
                    query = "CALL getMyStudentsGrades(?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    rs = preparedStmt.executeQuery();
                    while(rs.next()) {
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i)
                            returningData += rs.getString(i) + ";";
                        returningData += '*';
                    }
                    break;
                case GET_TEACHER_PROVIDED_ALL_GRADES_FROM:
                    query = "CALL getGradesFrom(?,?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    preparedStmt.setInt(2, Integer.parseInt(args.get(1)));
                    rs = preparedStmt.executeQuery();
                    while(rs.next()) {
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i)
                            returningData += rs.getString(i) + ";";
                        returningData += '*';
                    }
                    break;
                case ADD_TEACHER_STUDENT_GRADE:
                    query = "CALL addStudentGrade(?,?,?,?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    preparedStmt.setInt(2, Integer.parseInt(args.get(1)));
                    preparedStmt.setInt(3, Integer.parseInt(args.get(2)));
                    preparedStmt.setInt(4, Integer.parseInt(args.get(3)));
                    try {
                        con.setAutoCommit(false);
                        returningData = ";" + preparedStmt.executeUpdate();
                        con.commit();
                        System.out.println("Successfully committed changes to the database!");
                    }
                    catch (SQLException e) {
                        try {
                            con.rollback();
                            returningData = ";0";
                            System.out.println("Successfully rolled back changes to the database!");
                        }
                        catch (SQLException ex) {
                            System.out.println("Could not rollback updates " + e.getMessage());
                        }
                    }
                    break;
                case CHANGE_TEACHER_STUDENT_GRADE:
                    query = "CALL changeStudentGrade(?,?,?,?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    preparedStmt.setInt(2, Integer.parseInt(args.get(1)));
                    preparedStmt.setInt(3, Integer.parseInt(args.get(2)));
                    preparedStmt.setInt(4, Integer.parseInt(args.get(3)));
                    returningData = ";" + preparedStmt.executeUpdate();
                    break;
                case DELETE_TEACHER_STUDENT_GRADE:
                    query = "CALL deleteStudentGrade(?,?,?)";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    preparedStmt.setInt(2, Integer.parseInt(args.get(1)));
                    preparedStmt.setInt(3, Integer.parseInt(args.get(2)));
                    returningData = ";" + preparedStmt.executeUpdate();
                    break;
                case LOG_STUDENT:
                    query = "CALL loginStudent(?,?)";
                    passSalted = "&!N_@(C-&$-*(&-4vmN&#$_V&_m&%#V)MU4ly8mjyC$)V#" + args.get(1).toLowerCase();
                    sha1 = MessageDigest.getInstance("SHA-1");
                    sha1.update(passSalted.getBytes());
                    passSHA1 = DatatypeConverter.printHexBinary(sha1.digest());
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    preparedStmt.setString(2, passSHA1);
                    rs = preparedStmt.executeQuery();
                    while(rs.next())
                        returningData = ";" + rs.getInt(1);
                    break;
                case LOG_TEACHER:
                    query = "CALL loginTeacher(?,?)";
                    passSalted = "&!N_@(C-&$-*(&-4vmN&#$_V&_m&%#V)MU4ly8mjyC$)V#" + args.get(1).toLowerCase();
                    sha1 = MessageDigest.getInstance("SHA-1");
                    sha1.update(passSalted.getBytes());
                    passSHA1 = DatatypeConverter.printHexBinary(sha1.digest());
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(args.get(0)));
                    preparedStmt.setString(2, passSHA1);
                    rs = preparedStmt.executeQuery();
                    while(rs.next())
                        returningData = ";" + rs.getInt(1);
                    break;
            }
        }
        catch (Exception e) {
            throw new Error("Problem", e);
        }
        finally {
            if (preparedStmt != null) {
                preparedStmt.close();
            }
        }
        
        return returningData;
    }
}
