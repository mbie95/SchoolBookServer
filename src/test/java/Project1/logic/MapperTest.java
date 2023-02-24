package Project1.logic;

import Project1.logic.RequestType;
import Project1.logic.Mapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.IntStream.range;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author marcin
 */
public class MapperTest {
    @Test
    public void requestStudentDataById_ResultDataShouldBeSame() {
        //given
        String req = "STU;GET;1";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.GET_STUDENT_BY_ID.toString());
        result.put("MyId", "1");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestTeacherDataById_ResultDataShouldBeSame() {
        //given
        String req = "TEA;GET;1";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.GET_TEACHER_BY_ID.toString());
        result.put("MyId", "1");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestStudentChangeAddress_ResultDataShouldBeSame() {
        //given
        String req = "STU;CHA;1;asdfg;zxcvb;12345";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.CHANGE_STUDENT_ADDRESS.toString());
        result.put("MyId", "1");
        result.put("City", "asdfg");
        result.put("Street_and_number", "zxcvb");
        result.put("Post_code", "12345");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestTeacherChangeAddress_ResultDataShouldBeSame() {
        //given
        String req = "TEA;CHA;1;asdfg;zxcvb;12345";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.CHANGE_TEACHER_ADDRESS.toString());
        result.put("MyId", "1");
        result.put("City", "asdfg");
        result.put("Street_and_number", "zxcvb");
        result.put("Post_code", "12345");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestGetStudentGrades_ResultDataShouldBeSame() {
        //given
        String req = "STU;GET;GRA;1";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.GET_STUDENT_GRADES.toString());
        result.put("MyId", "1");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestGetStudentGradeFrom_ResultDataShouldBeSame() {
        //given
        String req = "STU;GET;1;2";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.GET_STUDENT_GRADE_FROM.toString());
        result.put("MyId", "1");
        result.put("SubjectId", "2");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestGetAllTeachersStudentsGrades_ResultDataShouldBeSame() {
        //given
        String req = "TEA;GET;GRA;1";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.GET_TEACHER_ALL_HIS_STUDENTS_GRADES.toString());
        result.put("MyId", "1");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestGetTeachersProvidedGradesFrom_ResultDataShouldBeSame() {
        //given
        String req = "TEA;GET;GRA;1;2";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.GET_TEACHER_PROVIDED_ALL_GRADES_FROM.toString());
        result.put("MyId", "1");
        result.put("SubjectId", "2");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestAddStudentGrade_ResultDataShouldBeSame() {
        //given
        String req = "TEA;ADD;1;2;3;6";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.ADD_TEACHER_STUDENT_GRADE.toString());
        result.put("MyId", "1");
        result.put("StudentId", "2");
        result.put("SubjectId", "3");
        result.put("Grade", "6");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestChangeStudentGrade_ResultDataShouldBeSame() {
        //given
        String req = "TEA;CHA;1;2;3;6";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.CHANGE_TEACHER_STUDENT_GRADE.toString());
        result.put("MyId", "1");
        result.put("StudentId", "2");
        result.put("SubjectId", "3");
        result.put("Grade", "6");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void requestDeleteStudentGrade_ResultDataShouldBeSame() {
        //given
        String req = "TEA;DEL;1;2;3";
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Task", RequestType.DELETE_TEACHER_STUDENT_GRADE.toString());
        result.put("MyId", "1");
        result.put("StudentId", "2");
        result.put("SubjectId", "3");
        
        //when
        map = mapper.requestingData(req);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void responseStudentDataById_ResultDataShouldBeSame() {
        //given
        String res = "1;asd;asd;2010-03-19;aaaaa 11;111111;qwerty;as;";
        RequestType reqType = RequestType.GET_STUDENT_BY_ID;
        Mapper mapper = new Mapper();
        Map<String, String> map;
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
        map = mapper.responsingData(reqType, res);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void responseTeacherDataById_ResultDataShouldBeSame() {
        //given
        String res = "1;ccc;ccc;1978-09-18;ddddd 55;33333;vvvvv;";
        RequestType reqType = RequestType.GET_TEACHER_BY_ID;
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Id", "1");
        result.put("First name", "ccc");
        result.put("Last name", "ccc");
        result.put("Date", "1978-09-18");
        result.put("City", "vvvvv");
        result.put("Street and number", "ddddd 55");
        result.put("Post code", "33333");
        
        //when
        map = mapper.responsingData(reqType, res);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void responseStudentChangeAddress_ResultDataShouldBeSame() {
        //given
        String res = ";1";
        RequestType reqType = RequestType.CHANGE_STUDENT_ADDRESS;
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Success", "1");
        
        //when
        map = mapper.responsingData(reqType, res);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void responseTeacherChangeAddress_ResultDataShouldBeSame() {
        //given
        String res = ";1";
        RequestType reqType = RequestType.CHANGE_TEACHER_ADDRESS;
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Success", "1");
        
        //when
        map = mapper.responsingData(reqType, res);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void responseGetStudentGrades_ResultDataShouldBeSame() {
        //given
        String res = "drynn;2;*poiuyt;3;*";
        RequestType reqType = RequestType.GET_STUDENT_GRADES;
        Mapper mapper = new Mapper();
        List<Map<String, String>> listMap;
        Map<String, String> result = new HashMap<>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        result.put("Subject name", "drynn");
        result.put("Grade", "2");
        list.add(result);
        result = new HashMap<>();
        result.put("Subject name", "poiuyt");
        result.put("Grade", "3");
        list.add(result);
        
        //when
        listMap = mapper.responsingData(reqType, res);

        //then
        assertEquals(2, list.size());
        range(0, list.size())
                .forEach(index -> {
                    Map<String, String> listElement = list.get(index);
                    Map<String, String> listMapElement = listMap.get(index);
                    listElement.keySet().stream().forEach(key -> {
                        assertEquals(listElement.get(key), listMapElement.get(key));
                    });
                });
    }
    
    @Test
    public void responseGetStudentGradeFrom_ResultDataShouldBeSame() {
        //given
        String res = "poiuyt;3;";
        RequestType reqType = RequestType.GET_STUDENT_GRADE_FROM;
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Subject name", "poiuyt");
        result.put("Grade", "3");
        
        //when
        map = mapper.responsingData(reqType, res);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void responseGetAllTeachersStudentsGrades_ResultDataShouldBeSame() {
        //given
        String res = "gfrdsrv4e;5;3;iii;iii;*";
        RequestType reqType = RequestType.GET_TEACHER_ALL_HIS_STUDENTS_GRADES;
        Mapper mapper = new Mapper();
        List<Map<String, String>> listMap;
        Map<String, String> result = new HashMap<>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        result.put("Subject name", "gfrdsrv4e");
        result.put("Grade", "5");
        result.put("StudentId", "3");
        result.put("Student firstName", "iii");
        result.put("Student lastName", "iii");
        list.add(result);
        
        //when
        listMap = mapper.responsingData(reqType, res);

        //then
        range(0, list.size())
                .forEach(index -> {
                    Map<String, String> listElement = list.get(index);
                    Map<String, String> listMapElement = listMap.get(index);
                    listElement.keySet().stream().forEach(key -> {
                        assertEquals(listElement.get(key), listMapElement.get(key));
                    });
                });
    }
    
    @Test
    public void responseGetTeachersProvidedGradesFrom_ResultDataShouldBeSame() {
        //given
        String res = "drynn;2;2;qwe;qwe;*drynn;3;3;iii;iii;*";
        RequestType reqType = RequestType.GET_TEACHER_PROVIDED_ALL_GRADES_FROM;
        Mapper mapper = new Mapper();
        List<Map<String, String>> listMap;
        Map<String, String> result = new HashMap<>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        result.put("Subject name", "drynn");
        result.put("Grade", "2");
        result.put("StudentId", "2");
        result.put("Student firstName", "qwe");
        result.put("Student lastName", "qwe");
        list.add(result);
        result = new HashMap<>();
        result.put("Subject name", "drynn");
        result.put("Grade", "3");
        result.put("StudentId", "3");
        result.put("Student firstName", "iii");
        result.put("Student lastName", "iii");
        list.add(result);
        
        //when
        listMap = mapper.responsingData(reqType, res);

        //then
        range(0, list.size())
                .forEach(index -> {
                    Map<String, String> listElement = list.get(index);
                    Map<String, String> listMapElement = listMap.get(index);
                    listElement.keySet().stream().forEach(key -> {
                        assertEquals(listElement.get(key), listMapElement.get(key));
                    });
                });
    }
    
    @Test
    public void responseAddStudentGrade_ResultDataShouldBeSame() {
        //given
        String res = ";1";
        RequestType reqType = RequestType.ADD_TEACHER_STUDENT_GRADE;
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Success", "1");
        
        //when
        map = mapper.responsingData(reqType, res);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void responseChangeStudentGrade_ResultDataShouldBeSame() {
        //given
        String res = ";1";
        RequestType reqType = RequestType.CHANGE_TEACHER_STUDENT_GRADE;
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Success", "1");
        
        //when
        map = mapper.responsingData(reqType, res);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
    
    @Test
    public void responseDeleteStudentGrade_ResultDataShouldBeSame() {
        //given
        String res = ";1";
        RequestType reqType = RequestType.DELETE_TEACHER_STUDENT_GRADE;
        Mapper mapper = new Mapper();
        Map<String, String> map;
        Map<String, String> result = new HashMap<>();
        result.put("Success", "1");
        
        //when
        map = mapper.responsingData(reqType, res);
        
        //then
        result.keySet().stream().forEach((key) -> {
            assertEquals(result.get(key), map.get(key));
        });
    }
}
