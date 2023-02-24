package Project1.model.Person.Teacher;

import Project1.model.Address.Address;
import Project1.model.Person.Person;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author marcin
 */
public class Teacher extends Person {
    private static int teachersCounter;
    private int id;
    
    Teacher(){
        super();
        this.id = teachersCounter++;
    }
    public Teacher(String firstName, String lastName, Date birthDate, Address address) {
        super(firstName, lastName, birthDate, address);
        this.id = teachersCounter++;
    }

    public int getId(){
        return id;
    }
    
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(this.firstName == ((Teacher)obj).firstName && this.lastName == ((Teacher)obj).lastName
            && this.birthDate.compareTo(((Teacher)obj).birthDate) == 0 && this.address.equals(((Teacher)obj).address))
            return true;
        return false;
    }
}
