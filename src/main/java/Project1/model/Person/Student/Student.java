package Project1.model.Person.Student;

import Project1.model.Address.Address;
import Project1.model.Person.Person;
import java.util.Date;

/**
 *
 * @author marcin
 */
public class Student extends Person {
    private static int studentsCounter;
    private int id;
    private String classNumber;
    
    Student() {
        super();
        this.id = studentsCounter++;
    }
    Student(String firstName, String lastName, Date birthDate, Address address, String classNumber) {
        super(firstName, lastName, birthDate, address);
        this.id = studentsCounter++;
        this.classNumber = classNumber;
    }

    public int getId(){
        return id;
    }
    public String getClassNumber(){
        return classNumber;
    }
    public static int getNumberOfStudents(){
        return studentsCounter;
    }
    
    @Override
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    @Override
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    @Override
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }
    @Override
    public void setAddress(Address address){
        this.address = address;
    }
    public void setClassNumber(String classNumber){
        this.classNumber = classNumber;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(this.firstName == ((Student)obj).firstName && this.lastName == ((Student)obj).lastName
            && this.birthDate.compareTo(((Student)obj).birthDate) == 0 && this.address.equals(((Student)obj).address)
            && this.classNumber == ((Student)obj).classNumber)
            return true;
        return false;
    }
}
