package Project1.model.Person.Student;

/**
 *
 * @author marcin
 */
public class ReadStudentById {
    private int id;
    
    ReadStudentById() {
    }
    
    ReadStudentById(Student st) {
        this.id = st.getId();
    }
    
    public ReadStudentById(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}