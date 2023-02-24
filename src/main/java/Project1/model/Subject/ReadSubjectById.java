package Project1.model.Subject;

/**
 *
 * @author marcin
 */
public class ReadSubjectById {
    private int id;
    
    ReadSubjectById() {
        
    }
    
    ReadSubjectById(Subject su) {
        this.id = su.getId();
    }
    
    public ReadSubjectById(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
