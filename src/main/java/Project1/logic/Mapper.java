package Project1.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author marcin
 */
//class which maps data, separates them, making tasks to execute
public class Mapper {
    private Map<String, String> outputData = new HashMap<String, String>();
    private List<Map<String, String>> listOutputData = new ArrayList<>();
    private String[] data;
    private String[][] multiData;
    private Integer numeric;
    private Integer FALLBACK_VALUE = -1;
    
    //maps input request from client
    Map<String, String> requestingData (String inputData) {
        outputData = new HashMap<String, String>();
        listOutputData = new ArrayList<>();
        
        data = inputData.split(";");
        
        if (data[0].equals("TEA")) {
            requestingDataTeacher();
        }
        else if (data[0].equals("STU")) {
            requestingDataStudent();
        }
        return outputData;
    }
    
    //creates response json for client
    <T> T responsingData (RequestType task, String inputData) {
        outputData = new HashMap<String, String>();
        listOutputData = new ArrayList<>();
        
        switch (task) {
            case GET_STUDENT_BY_ID:
                return (T) responsingDataStudentById(inputData);
            case GET_TEACHER_BY_ID:
                return (T) responsingDataTeacherById(inputData);
            case CHANGE_STUDENT_ADDRESS:
                return (T) responsingChangeStudentAddress(inputData);
            case CHANGE_TEACHER_ADDRESS:
                return (T) responsingChangeTeacherAddress(inputData);
            case GET_STUDENT_GRADES:
                return (T) responsingGetStudentByIdGrades(inputData);
            case GET_STUDENT_GRADE_FROM:
                return (T) responsingGetStudentByIdGradesFrom(inputData);
            case GET_TEACHER_ALL_HIS_STUDENTS_GRADES:
                return (T) responsingGetTeacherAllHisStudentGrades(inputData);
            case GET_TEACHER_PROVIDED_ALL_GRADES_FROM:
                return (T) responsingGetTeacherProvidedAllGradesFrom(inputData);
            case ADD_TEACHER_STUDENT_GRADE:
                return (T) responsingAddStudentGrade(inputData);
            case CHANGE_TEACHER_STUDENT_GRADE:
                return (T) responsingAddStudentGrade(inputData);
            case DELETE_TEACHER_STUDENT_GRADE:
                return (T) responsingAddStudentGrade(inputData);
            case LOG_STUDENT:
                return (T) responsingLogInStudent(inputData);
            case LOG_TEACHER:
                return (T) responsingLogInTeacher(inputData);
        }
        return null;
    }
    
    private void requestingDataTeacher() {
        if (data[1].equals("GET")) {
            if (data.length == 3) {
                outputData.put("MyId", data[2]);
                outputData.put("Task", RequestType.GET_TEACHER_BY_ID.toString());
            }
            else if(data.length == 4) {
                outputData.put("MyId", data[3]);
                outputData.put("Task", RequestType.GET_TEACHER_ALL_HIS_STUDENTS_GRADES.toString());
            }
            else if(data.length == 5) {
                outputData.put("MyId", data[3]);
                outputData.put("Task", RequestType.GET_TEACHER_PROVIDED_ALL_GRADES_FROM.toString());
                outputData.put("SubjectId", data[4]);
            }
        }
        else if (data[1].equals("ADD")) {
            outputData.put("MyId", data[2]);
            outputData.put("Task", RequestType.ADD_TEACHER_STUDENT_GRADE.toString());
            requestingDataStudentSubjectGrade();
        }
        else if (data[1].equals("CHA")) {
            outputData.put("MyId", data[2]);
            requestingDataTeacherChange();
        }
        else if (data[1].equals("DEL")) {
            outputData.put("MyId", data[2]);
            outputData.put("Task", RequestType.DELETE_TEACHER_STUDENT_GRADE.toString());
            requestingDataStudentSubjectGradeDeletion();
        }
        else if (data[1].equals("LOG")) {
            outputData.put("MyId", data[2]);
            outputData.put("Task", RequestType.LOG_TEACHER.toString());
            requestingLogIn();
        }
    }
    
    private void requestingDataStudent() {
        if (data[1].equals("GET")) {
            if (data.length == 3) {
                outputData.put("MyId", data[2]);
                outputData.put("Task", RequestType.GET_STUDENT_BY_ID.toString());
            }
            else {
                requestingDataStudentGet4DataLength();
            }
        }
        else if (data[1].equals("CHA")) {
            outputData.put("MyId", data[2]);
            outputData.put("Task", RequestType.CHANGE_STUDENT_ADDRESS.toString());
            requestingDataAddress();
        }
        else if (data[1].equals("LOG")) {
            outputData.put("MyId", data[2]);
            outputData.put("Task", RequestType.LOG_STUDENT.toString());
            requestingLogIn();
        }
    }
    
    private void requestingDataTeacherChange() {
        outputData.put("MyId", data[2]);
        try {
            numeric = Optional.of(data[3]).map(Integer::valueOf).orElse(FALLBACK_VALUE);
            outputData.put("Task", RequestType.CHANGE_TEACHER_STUDENT_GRADE.toString());
            requestingDataStudentSubjectGrade();
        }
        catch (NumberFormatException e) {
            outputData.put("Task", RequestType.CHANGE_TEACHER_ADDRESS.toString());
            requestingDataAddress();
        }
    }
    
    private void requestingDataStudentGet4DataLength() {
        try {
            numeric = Optional.of(data[2]).map(Integer::valueOf).orElse(FALLBACK_VALUE);
            outputData.put("MyId", data[2]);
            outputData.put("Task", RequestType.GET_STUDENT_GRADE_FROM.toString());
            outputData.put("SubjectId", data[3]);
        }
        catch (NumberFormatException e) {
            outputData.put("MyId", data[3]);
            outputData.put("Task", RequestType.GET_STUDENT_GRADES.toString());
        }
    }
    
    private void requestingDataAddress() {
        outputData.put("City", data[3]);
        outputData.put("Street_and_number", data[4]);
        outputData.put("Post_code", data[5]);
    }
    
    private void requestingDataStudentSubjectGrade() {
        outputData.put("StudentId", data[3]);
        outputData.put("SubjectId", data[4]);
        outputData.put("Grade", data[5]);
    }
    
    private void requestingDataStudentSubjectGradeDeletion() {
        outputData.put("StudentId", data[3]);
        outputData.put("SubjectId", data[4]);
    }
    
    private void requestingLogIn() {
        outputData.put("Password", data[3]);
    }
    
    private void multiDataSplit(String inputData) {
        data = inputData.split("[*]");
        multiData = new String [data.length][];
        for (int i = 0; i < data.length; ++i)
            multiData[i] = data[i].split(";");
    }
    
    private Map<String, String> responsingDataStudentById(String inputData) {
        data = inputData.split(";");
        
        outputData.put("Id", data[0]);
        outputData.put("First name", data[1]);
        outputData.put("Last name", data[2]);
        outputData.put("Date", data[3]);
        outputData.put("City", data[6]);
        outputData.put("Street and number", data[4]);
        outputData.put("Post code", data[5]);
        outputData.put("Class number", data[7]);
        
        return outputData;
    }
    
    private Map<String, String> responsingDataTeacherById(String inputData) {
        data = inputData.split(";");
        
        outputData.put("Id", data[0]);
        outputData.put("First name", data[1]);
        outputData.put("Last name", data[2]);
        outputData.put("Date", data[3]);
        outputData.put("City", data[6]);
        outputData.put("Street and number", data[4]);
        outputData.put("Post code", data[5]);
        
        return outputData;
    }
    
    private Map<String, String> responsingChangeStudentAddress(String inputData) {
        data = inputData.split(";");
        outputData.put("Success", data[1]);
        
        return outputData;
    }
    
    private Map<String, String> responsingChangeTeacherAddress(String inputData) {
        data = inputData.split(";");
        outputData.put("Success", data[1]);
        
        return outputData;
    }
    
    private List<Map<String, String>> responsingGetStudentByIdGrades(String inputData) {
        multiDataSplit(inputData);
        for (int i = 0; i < multiData.length; ++i) {
            outputData = new HashMap<String, String>();
            outputData.put("Subject name", multiData[i][0]);
            outputData.put("Grade", multiData[i][1]);
            listOutputData.add(outputData);
        }
        
        return listOutputData;
    }

    private Map<String, String> responsingGetStudentByIdGradesFrom(String inputData) {
        data = inputData.split(";");
        outputData.put("Subject name", data[0]);
        outputData.put("Grade", data[1]);
        
        return outputData;
    }

    private List<Map<String, String>> responsingGetTeacherAllHisStudentGrades(String inputData) {
        multiDataSplit(inputData);
        for (int i = 0; i < multiData.length; ++i) {
            outputData = new HashMap<String, String>();
            outputData.put("Subject name", multiData[i][0]);
            outputData.put("Grade", multiData[i][1]);
            outputData.put("StudentId", multiData[i][2]);
            outputData.put("Student firstName", multiData[i][3]);
            outputData.put("Student lastName", multiData[i][4]);
            listOutputData.add(outputData);
        }
        
        return listOutputData;
    }

    private List<Map<String, String>> responsingGetTeacherProvidedAllGradesFrom(String inputData) {
        multiDataSplit(inputData);
        for (int i = 0; i < multiData.length; ++i) {
            outputData = new HashMap<String, String>();
            outputData.put("Subject name", multiData[i][0]);
            outputData.put("Grade", multiData[i][1]);
            outputData.put("StudentId", multiData[i][2]);
            outputData.put("Student firstName", multiData[i][3]);
            outputData.put("Student lastName", multiData[i][4]);
            listOutputData.add(outputData);
        }
        
        return listOutputData;
    }

    private Map<String, String> responsingAddStudentGrade(String inputData) {
        data = inputData.split(";");
        outputData.put("Success", data[1]);
        
        return outputData;
    }
    
    private Map<String, String> responsingChangeStudentGrade(String inputData) {
        data = inputData.split(";");
        outputData.put("Success", data[1]);
        
        return outputData;
    }
    
    private Map<String, String> responsingDeleteStudentGrade(String inputData) {
        data = inputData.split(";");
        outputData.put("Success", data[1]);
        
        return outputData;
    }
    
    private Map<String, String> responsingLogInStudent(String inputData) {
        data = inputData.split(";");
        outputData.put("Success", data[1]);
        
        return outputData;
    }
    
    private Map<String, String> responsingLogInTeacher(String inputData) {
        data = inputData.split(";");
        outputData.put("Success", data[1]);
        
        return outputData;
    }
}
