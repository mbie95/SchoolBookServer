package Project1.model.Grade;

/**
 *
 * @author marcin
 */
public class WriteGrade {
    private int grade;
    
    WriteGrade() {
        
    }
    
    WriteGrade(Grade g) {
        this.grade = g.getGrade();
    }
    
    public WriteGrade(int grade) {
        this.grade = grade;
    }
    
    public int getGrade() {
        return grade;
    }
}
