package Project1.logic;

import Project1.model.Repository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.json.simple.JSONValue;
import static org.junit.Assert.assertNotEquals;

/**
 *
 * @author marcin
 */
public class ServiceTest {
    
    private Repository getMockRepository() {
        return new Repository() {
            @Override
            public String connect(Transaction transaction) throws ClassNotFoundException, SQLException {
                if (transaction.getTransactionType() == RequestType.GET_STUDENT_BY_ID) {
                    return "1;asd;asd;2010-03-19;aaaaa 11;111111;qwerty;as;";
                }
                else if (transaction.getTransactionType() == RequestType.CHANGE_TEACHER_ADDRESS) {
                    return ";1";
                }
                else if (transaction.getTransactionType() == RequestType.GET_STUDENT_GRADES) {
                    return "drynn;2;*poiuyt;3;*ytjfhd;4;*";
                }
                else if (transaction.getTransactionType() == null) {
                    return "";
                }
                
                return "";
            }
        };
    }
    
    @Test
    public void serviceGetStudentByIdTest_ResultDataShouldBeSame() throws ClassNotFoundException, SQLException {
        //given
        Repository mockRepository = getMockRepository();
        Service sut = new Service(mockRepository);
        Map<String, String> result = new HashMap<>();
        result.put("Id", "1");
        result.put("First name", "asd");
        result.put("Last name", "asd");
        result.put("Date", "2010-03-19");
        result.put("City", "qwerty");
        result.put("Street and number", "aaaaa 11");
        result.put("Post code", "111111");
        result.put("Class number", "as");
        
        //when
        String json = sut.request("STU;GET;1");
        
        //then
        assertEquals(JSONValue.toJSONString(result), json);
    }
    
    @Test
    public void serviceGetStudentByIdTest_ResultDataShouldNotBeSame() throws ClassNotFoundException, SQLException {
        //given
        Repository mockRepository = getMockRepository();
        Service sut = new Service(mockRepository);
        Map<String, String> result = new HashMap<>();
        result.put("Id", "1");
        result.put("First name", "asd");
        result.put("Last name", "asd");
        result.put("Date", "2010-03-19");
        result.put("City", "qwerty");
        result.put("Street and number", "aaaaa 11");
        result.put("Post code", "99999");
        result.put("Class number", "as");
        
        //when
        String json = sut.request("STU;GET;1");
        
        //then
        assertNotEquals(JSONValue.toJSONString(result), json);
    }
    
    @Test
    public void serviceChangeTeacherAddressTest_ResultDataShouldBeSame() throws ClassNotFoundException, SQLException {
        //given
        Repository mockRepository = getMockRepository();
        Service sut = new Service(mockRepository);
        Map<String, String> result = new HashMap<>();
        result.put("Success", "1");
        
        //when
        String json = sut.request("TEA;CHA;1;asdfg;zxcvb;12345");
        
        //then
        assertEquals(JSONValue.toJSONString(result), json);
    }
    
    @Test
    public void serviceChangeTeacherAddressTest_ResultDataShouldNotBeSame() throws ClassNotFoundException, SQLException {
        //given
        Repository mockRepository = getMockRepository();
        Service sut = new Service(mockRepository);
        Map<String, String> result = new HashMap<>();
        result.put("Success", "0");
        
        //when
        String json = sut.request("TEA;CHA;1;asdfg;zxcvb;12345");
        
        //then
        assertNotEquals(JSONValue.toJSONString(result), json);
    }
    
    @Test
    public void serviceGetStudentGradesTest_ResultDataShouldBeSame() throws ClassNotFoundException, SQLException {
        //given
        Repository mockRepository = getMockRepository();
        Service sut = new Service(mockRepository);
        Map<String, String> result = new HashMap<>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        result.put("Subject name", "drynn");
        result.put("Grade", "2");
        list.add(result);
        result = new HashMap<>();
        result.put("Subject name", "poiuyt");
        result.put("Grade", "3");
        list.add(result);
        result = new HashMap<>();
        result.put("Subject name", "ytjfhd");
        result.put("Grade", "4");
        list.add(result);
        
        //when
        String json = sut.request("STU;GET;GRA;1");
        
        //then
        assertEquals(JSONValue.toJSONString(list), json);
    }
    
    @Test
    public void serviceGetStudentGradesTest_ResultDataShouldNotBeSame() throws ClassNotFoundException, SQLException {
        //given
        Repository mockRepository = getMockRepository();
        Service sut = new Service(mockRepository);
        Map<String, String> result = new HashMap<>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        result.put("Subject name", "drynn");
        result.put("Grade", "2");
        list.add(result);
        result = new HashMap<>();
        result.put("Subject name", "poiuyt");
        result.put("Grade", "1");
        list.add(result);
        result = new HashMap<>();
        result.put("Subject name", "ytjfhd");
        result.put("Grade", "4");
        list.add(result);
        
        //when
        String json = sut.request("STU;GET;GRA;1");
        
        //then
        assertNotEquals(JSONValue.toJSONString(list), json);
    }
    
    @Test
    public void serviceErrorMessageInJsonTest_ErrorsShouldBeSame() throws ClassNotFoundException, SQLException {
        //given
        Repository mockRepository = getMockRepository();
        Service sut = new Service(mockRepository);
        Map<String, String> result = new HashMap<>();
        result.put("Error", "Problem with server!");
        
        //when
        String json = sut.request("");
        
        //then
        assertEquals(JSONValue.toJSONString(result), json);
    }
}
