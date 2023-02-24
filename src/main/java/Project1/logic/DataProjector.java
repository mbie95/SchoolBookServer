package Project1.logic;

import Project1.model.Address.WriteAddress;
import Project1.model.Grade.WriteGrade;
import Project1.model.Person.ReadPersonById;
import Project1.model.Person.ReadPersonLogIn;
import Project1.model.Person.Student.ReadStudentById;
import Project1.model.Subject.ReadSubjectById;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author marcin
 */
//class is projecting mapped data, to separate arguments, order them
public class DataProjector {
    private RequestType requestType;
    private Set<Object> dtosSet;
    
    DataProjector() {
        dtosSet = new HashSet<>();
    }

    public RequestType getRequestType() {
        return requestType;
    }
    
    //creating set of dtos objects from entities, including info about request
    Set<Object> convert(Map<String, String> data) {
        dtosSet = new HashSet<>();
        
        addRequestType(data.get("Task"));
        if (data.get("Password") != null) {
            addPersonLogIn(data.get("MyId"), data.get("Password"));
            return dtosSet;
        }
        addPersonId(data.get("MyId"));
        if (data.get("SubjectId") != null) {
            addSubjectId(data.get("SubjectId")); 
        }
        if (data.get("StudentId") != null) {
            addStudentId(data.get("StudentId")); 
        }
        if (data.get("Grade") != null) {
            addGrade(data.get("Grade")); 
        }
        if (data.get("City") != null) {
            addAddress(data.get("City"), data.get("Street_and_number"), data.get("Post_code"));
        }
        
        return dtosSet;
    }
    
    private void addRequestType(String str) {
        switch (str) {
            case "GET_STUDENT_BY_ID":
                requestType = RequestType.GET_STUDENT_BY_ID;
                break;
            case "CHANGE_STUDENT_ADDRESS":
                requestType = RequestType.CHANGE_STUDENT_ADDRESS;
                break;
            case "GET_STUDENT_GRADES":
                requestType = RequestType.GET_STUDENT_GRADES;
                break;
            case "GET_STUDENT_GRADE_FROM":
                requestType = RequestType.GET_STUDENT_GRADE_FROM;
                break;
            case "GET_TEACHER_BY_ID":
                requestType = RequestType.GET_TEACHER_BY_ID;
                break;
            case "CHANGE_TEACHER_ADDRESS":
                requestType = RequestType.CHANGE_TEACHER_ADDRESS;
                break;
            case "GET_TEACHER_ALL_HIS_STUDENTS_GRADES":
                requestType = RequestType.GET_TEACHER_ALL_HIS_STUDENTS_GRADES;
                break;
            case "GET_TEACHER_PROVIDED_ALL_GRADES_FROM":
                requestType = RequestType.GET_TEACHER_PROVIDED_ALL_GRADES_FROM;
                break;
            case "ADD_TEACHER_STUDENT_GRADE":
                requestType = RequestType.ADD_TEACHER_STUDENT_GRADE;
                break;
            case "CHANGE_TEACHER_STUDENT_GRADE":
                requestType = RequestType.CHANGE_TEACHER_STUDENT_GRADE;
                break;
            case "DELETE_TEACHER_STUDENT_GRADE":
                requestType = RequestType.DELETE_TEACHER_STUDENT_GRADE;
                break;
            case "LOG_STUDENT":
                requestType = RequestType.LOG_STUDENT;
                break;
            case "LOG_TEACHER":
                requestType = RequestType.LOG_TEACHER;
                break;
        }
        dtosSet.add(requestType);
    }
    
    private void addPersonLogIn(String id, String pass) {
        ReadPersonLogIn dto;
        try {
            dto = new ReadPersonLogIn(Integer.parseInt(id), pass);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Id musi byc liczba");
        }
        
        dtosSet.add(dto);
    }
    
    private void addPersonId(String str) {
        ReadPersonById dto;
        try {
            dto = new ReadPersonById(Integer.parseInt(str));
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Id musi byc liczba");
        }
        
        dtosSet.add(dto);
    }
    
    private void addSubjectId(String str) {
        ReadSubjectById dto;
        try {
            dto = new ReadSubjectById(Integer.parseInt(str));
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Id musi byc liczba");
        }
        
        dtosSet.add(dto);
    }

    private void addStudentId(String str) {
        ReadStudentById dto;
        try {
            dto = new ReadStudentById(Integer.parseInt(str));
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Id musi byc liczba");
        }
        
        dtosSet.add(dto);
    }

    private void addGrade(String str) {
        WriteGrade dto;
        try {
            dto = new WriteGrade(Integer.parseInt(str));
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Id musi byc liczba");
        }
        
        dtosSet.add(dto);
    }

    private void addAddress(String city, String str, String post) {
        WriteAddress dto;
        dto = new WriteAddress(city, str, post);
        
        dtosSet.add(dto);
    }
}
