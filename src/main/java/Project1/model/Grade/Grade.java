package Project1.model.Grade;

/**
 *
 * @author marcin
 */
public class Grade {
    private int idStudent;
    private int idSubject;
    private int grade;
    
    Grade() {
        
    }
    
    Grade(int idStudent, int idSubject, int grade) {
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.grade = grade;
    }
    
    public int getIdStudent(){
        return idStudent;
    }
    
    public int getIdSubject(){
        return idSubject;
    }
    
    public int getGrade(){
        return grade;
    }
    
    public void setIdStudent(int idStudent){
        this.idStudent = idStudent;
    }
    
    public void setIdSubject(int idSubject){
        this.idSubject = idSubject;
    }
    
    public void setGrade(int grade){
        this.grade = grade;
    }
}
