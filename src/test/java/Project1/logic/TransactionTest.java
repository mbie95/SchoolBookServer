package Project1.logic;

import Project1.logic.Transaction;
import static Project1.logic.RequestType.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marcin
 */
public class TransactionTest {
    Connection con = null;
    
    @Before
    public void createDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/StudentBook","root","");  
    }
    
    @After
    public void shutdownDatabase() throws SQLException {
        con.close();
    }
    
    @Test
    public void transactionGetStudentByIdTest_ResultDataShouldBeSame() throws SQLException, ParseException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("1")); 
        Transaction transaction = new Transaction(GET_STUDENT_BY_ID, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals("1;asd;asd;2010-03-19;asdfghj 90;12345;qwerty;as;b270077d2830df2390122ad7fa62236e79227b99;", resultData);
    }
    
    @Test
    public void transactionGetTeacherByIdTest_ResultDataShouldBeSame() throws SQLException, ParseException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("1")); 
        Transaction transaction = new Transaction(GET_TEACHER_BY_ID, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals("1;ccc;ccc;1978-09-18;ddddd 55;33333;vvvvv;2ba44e72cedb30d4ea94a162b6ee8b896bd497c1;", resultData);
    }
    
    @Test
    public void transactionChangeStudentAddressTest_ResultDataShouldBeSame() throws SQLException, ParseException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("3","City","Street XX","12-345")); 
        Transaction transaction = new Transaction(CHANGE_TEACHER_ADDRESS, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals(";1", resultData);
    }
    
    @Test
    public void transactionChangeTeacherAddressTest_ResultDataShouldBeSame() throws SQLException, ParseException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("4","City","Street XX","12-345")); 
        Transaction transaction = new Transaction(CHANGE_STUDENT_ADDRESS, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals(";1", resultData);
    }
    
    @Test
    public void transactionGetAllStudentGradesTest_ResultDataShouldBeSame() throws SQLException, ParseException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("2")); 
        Transaction transaction = new Transaction(GET_STUDENT_GRADES, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals("drynn;2;*poiuyt;3;*", resultData);
    }
    
    @Test
    public void transactionGetStudentGradeFromTest_ResultDataShouldBeSame() throws SQLException, ParseException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("2","1")); 
        Transaction transaction = new Transaction(GET_STUDENT_GRADE_FROM, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals("poiuyt;3;", resultData);
    }
    
    @Test
    public void transactionGetAllTeachersStudentsGradesTest_ResultDataShouldBeSame() throws SQLException, ParseException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("3")); 
        Transaction transaction = new Transaction(GET_TEACHER_ALL_HIS_STUDENTS_GRADES, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals("gfrdsrv4e;5;3;iii;iii;*", resultData);
    }
    
    @Test
    public void transactionGetTeachersProvidedGradesFromTest_ResultDataShouldBeSame() throws SQLException, ParseException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("2","2")); 
        Transaction transaction = new Transaction(GET_TEACHER_PROVIDED_ALL_GRADES_FROM, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals("drynn;2;2;qwe;qwe;*drynn;3;3;iii;iii;*", resultData);
    }
    /*
    @Test
    public void transactionAddStudentGradeTest_ResultDataShouldBeSame() throws SQLException, ParseException, InterruptedException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("2","1","5","4")); 
        Transaction transaction = new Transaction(ADD_TEACHER_STUDENT_GRADE, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals(";1", resultData);
        
        //checking
        //given
        args = new ArrayList<>(Arrays.asList("1","5")); 
        transaction = new Transaction(GET_STUDENT_GRADE_FROM, args);
        
        //when
        resultData = transaction.execute(con);
        
        //then
        assertEquals("trdfstgdf;4;", resultData);
    }
    
    @Test
    public void transactionChangeStudentGradeTest_ResultDataShouldBeSame() throws SQLException, ParseException, InterruptedException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("2","1","5","5")); 
        Transaction transaction = new Transaction(CHANGE_TEACHER_STUDENT_GRADE, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals(";1", resultData);
    
        //checking
        //given
        args = new ArrayList<>(Arrays.asList("1","5")); 
        transaction = new Transaction(GET_STUDENT_GRADE_FROM, args);
        
        //when
        resultData = transaction.execute(con);
        
        //then
        assertEquals("trdfstgdf;5;", resultData);
    }
    
    @Test
    public void transactionDeleteStudentGradeTest_ResultDataShouldBeSame() throws SQLException, ParseException, InterruptedException {
        //given
        ArrayList<String> args = new ArrayList<>(Arrays.asList("2","1","5")); 
        Transaction transaction = new Transaction(DELETE_TEACHER_STUDENT_GRADE, args);
        
        //when
        String resultData = transaction.execute(con);
        
        //then
        assertEquals(";1", resultData);
        
        //checking
        //given
        args = new ArrayList<>(Arrays.asList("1","5")); 
        transaction = new Transaction(GET_STUDENT_GRADE_FROM, args);
        
        //when
        resultData = transaction.execute(con);
        
        //then
        assertEquals("", resultData);
    }
    */
}
