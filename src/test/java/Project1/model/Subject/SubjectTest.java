package Project1.model.Subject;

import Project1.model.Person.Teacher.Teacher;
import Project1.model.Address.Address;
import Project1.model.Subject.Subject;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SubjectTest 
{
    Subject subject1 = new Subject();
    
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void subjectDefaultConstructorTest_ShouldNotBeNull() {
        assertNotNull("should not be null", new Subject());
    }
    
    @Test
    public void subjectTwoParamConstructoTest_ShouldNotBeNull() {
        assertNotNull("should not be null", new Subject("Matematyka", new Teacher("Jan", "Kowalski", 
                new Date(2010,5,15), new Address("Nowe Miasto", "Topolowa 58", "65-345"))));
    }
    
    @Test
    public void subjectTwoParamConstructorTest_AllElementsShouldBeSame() {
        Subject subject = new Subject("Matematyka", new Teacher("Jan", "Kowalski", 
                new Date(2010,5,15), new Address("Nowe Miasto", "Topolowa 58", "65-345")));
        assertThat(subject.getName(), is("Matematyka"));
        assertThat(subject.getTeacher(), is(new Teacher("Jan", "Kowalski", 
                new Date(2010,5,15), new Address("Nowe Miasto", "Topolowa 58", "65-345"))));
    }
    
    @Test
    public void subjectSetNameTest_ShouldBeEqual(){
        subject1.setName("Matematyka");
        assertThat(subject1.getName(), is("Matematyka"));
    }
    
    @Test
    public void subjectSetTeacherTest_ShouldBeEqual(){
        subject1.setTeacher(new Teacher("Jan", "Kowalski", 
                new Date(2010,5,15), new Address("Nowe Miasto", "Topolowa 58", "65-345")));
        assertThat(subject1.getTeacher(), is(new Teacher("Jan", "Kowalski", 
                new Date(2010,5,15), new Address("Nowe Miasto", "Topolowa 58", "65-345"))));
    }
    
    @Test
    public void subjectArrayListTest_AllElementsShouldBeSame(){
        ArrayList<Subject> listOfSubjects = new ArrayList<Subject>();
        listOfSubjects.add(new Subject("Matematyka", new Teacher("Jan", "Kowalski", 
                new Date(1973,5,15), new Address("Nowe Miasto", "Topolowa 58", "65-345"))));
        listOfSubjects.add(new Subject("Fizyka", new Teacher("Konrad", "Nowak", 
                new Date(1977,8,23), new Address("Nowe Miasto", "Fiolkowa 12", "65-345"))));
        listOfSubjects.add(new Subject("Fizyka", new Teacher("Elzbieta", "Malinowska", 
                new Date(1972,2,6), new Address("Nowe Miasto", "Drzewiasta 98", "65-345"))));
        assertThat(listOfSubjects.size(), is(3));
        assertThat(listOfSubjects.get(0), is(new Subject("Matematyka", new Teacher("Jan", "Kowalski", 
                new Date(1973,5,15), new Address("Nowe Miasto", "Topolowa 58", "65-345")))));
        assertThat(listOfSubjects.get(1), is(new Subject("Fizyka", new Teacher("Konrad", "Nowak", 
                new Date(1977,8,23), new Address("Nowe Miasto", "Fiolkowa 12", "65-345")))));
        assertThat(listOfSubjects.get(2), is(new Subject("Fizyka", new Teacher("Elzbieta", "Malinowska", 
                new Date(1972,2,6), new Address("Nowe Miasto", "Drzewiasta 98", "65-345")))));
    }
}
