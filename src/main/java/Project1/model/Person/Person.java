package Project1.model.Person;

import Project1.model.Address.Address;
import java.util.Date;

/**
 *
 * @author marcin
 */
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected Date birthDate;
    protected Address address;
    
    protected Person() {
        
    }
    protected Person(String firstName, String lastName, Date birthDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Date getBirthDate(){
        return birthDate;
    }
    public Address getAddress(){
        return address;
    }
    
    public abstract void setFirstName(String firstName);
    public abstract void setLastName(String lastName);
    public abstract void setBirthDate(Date birthDate);
    public abstract void setAddress(Address address);
}
