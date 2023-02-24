package Project1.model.Person;

import Project1.model.Person.Student.Student;
import Project1.model.Person.Teacher.Teacher;

/**
 *
 * @author marcin
 */
public class ReadPersonById {
    private int id;
    
    ReadPersonById() {
    }
    
    ReadPersonById(Student st) {
        this.id = st.getId();
    }
    
    ReadPersonById(Teacher te) {
        this.id = te.getId();
    }
    
    public ReadPersonById(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
