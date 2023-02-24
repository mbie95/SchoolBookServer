package Project1.logic;

import Project1.model.Address.WriteAddress;
import Project1.model.Grade.WriteGrade;
import Project1.model.Person.ReadPersonById;
import Project1.model.Person.Student.ReadStudentById;
import Project1.model.Subject.ReadSubjectById;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 *
 * @author marcin
 */
public class DataProjectorTest {
    @Test
    public void convertStudentChangeAddressData_ResultDataShouldBeSame() {
        Map<String, String> map = new HashMap<>();
        DataProjector projector = new DataProjector();
        Set<Object> resultSet;
        map.put("Task", RequestType.CHANGE_STUDENT_ADDRESS.toString());
        map.put("MyId", "1");
        map.put("City", "asdfg");
        map.put("Street_and_number", "zxcvb");
        map.put("Post_code", "12345");
        
        resultSet = projector.convert(map);
        
        assertEquals(RequestType.CHANGE_STUDENT_ADDRESS, projector.getRequestType());
        
        for(Object obj: resultSet) {
            if (obj.getClass() == ReadPersonById.class)
                assertEquals(1, ((ReadPersonById)obj).getId());
            else if (obj.getClass() == WriteAddress.class) {
                assertEquals("asdfg", ((WriteAddress)obj).getCity());
                assertEquals("zxcvb", ((WriteAddress)obj).getStreet_and_number());
                assertEquals("12345", ((WriteAddress)obj).getPost_code());
            }
        }
    }
    
    @Test
    public void convertStudentChangeAddressData_AllResultDataShouldNotBeSame() {
        Map<String, String> map = new HashMap<>();
        DataProjector projector = new DataProjector();
        Set<Object> resultSet;
        map.put("Task", RequestType.CHANGE_STUDENT_ADDRESS.toString());
        map.put("MyId", "1");
        map.put("City", "asdfg");
        map.put("Street_and_number", "zxcvb");
        map.put("Post_code", "12345");
        
        resultSet = projector.convert(map);
        
        assertNotEquals(RequestType.CHANGE_TEACHER_ADDRESS, projector.getRequestType());
        
        for(Object obj: resultSet) {
            if (obj.getClass() == ReadPersonById.class)
                assertNotEquals(2, ((ReadPersonById)obj).getId());
            else if (obj.getClass() == WriteAddress.class) {
                assertNotEquals("asdfgh", ((WriteAddress)obj).getCity());
                assertNotEquals("zxcvbn", ((WriteAddress)obj).getStreet_and_number());
                assertNotEquals("123456", ((WriteAddress)obj).getPost_code());
            }
        }
    }
    
    @Test
    public void convertAddStudentGrade_ResultDataShouldBeSame() {
        Map<String, String> map = new HashMap<>();
        DataProjector projector = new DataProjector();
        Set<Object> resultSet;
        map.put("Task", RequestType.ADD_TEACHER_STUDENT_GRADE.toString());
        map.put("MyId", "1");
        map.put("StudentId", "2");
        map.put("SubjectId", "3");
        map.put("Grade", "4");
        
        resultSet = projector.convert(map);
        
        assertEquals(RequestType.ADD_TEACHER_STUDENT_GRADE, projector.getRequestType());
        
        for(Object obj: resultSet) {
            if (obj.getClass() == ReadPersonById.class)
                assertEquals(1, ((ReadPersonById)obj).getId());
            else if (obj.getClass() == ReadStudentById.class)
                assertEquals(2, ((ReadStudentById)obj).getId());
            else if (obj.getClass() == ReadSubjectById.class)
                assertEquals(3, ((ReadSubjectById)obj).getId());
            else if (obj.getClass() == WriteGrade.class)
                assertEquals(4, ((WriteGrade)obj).getGrade());
        }
    }
    
    @Test
    public void convertAddStudentGrade_AllResultDataShouldNotBeSame() {
        Map<String, String> map = new HashMap<>();
        DataProjector projector = new DataProjector();
        Set<Object> resultSet;
        map.put("Task", RequestType.ADD_TEACHER_STUDENT_GRADE.toString());
        map.put("MyId", "1");
        map.put("StudentId", "2");
        map.put("SubjectId", "3");
        map.put("Grade", "4");
        
        resultSet = projector.convert(map);
        
        assertNotEquals(RequestType.CHANGE_TEACHER_STUDENT_GRADE, projector.getRequestType());
        
        for(Object obj: resultSet) {
            if (obj.getClass() == ReadPersonById.class)
                assertNotEquals(9, ((ReadPersonById)obj).getId());
            else if (obj.getClass() == ReadStudentById.class)
                assertNotEquals(8, ((ReadStudentById)obj).getId());
            else if (obj.getClass() == ReadSubjectById.class)
                assertNotEquals(7, ((ReadSubjectById)obj).getId());
            else if (obj.getClass() == WriteGrade.class)
                assertNotEquals(6, ((WriteGrade)obj).getGrade());
        }
    }
}
