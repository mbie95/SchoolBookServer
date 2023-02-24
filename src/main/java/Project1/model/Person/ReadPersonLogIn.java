package Project1.model.Person;

/**
 *
 * @author marcin
 */
public class ReadPersonLogIn {
    private int id;
    private String pass;
    
    ReadPersonLogIn() {
    }
    
    public ReadPersonLogIn(int id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }
}