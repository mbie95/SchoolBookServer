package Project1.model.Person.Student;

import Project1.model.Person.Student.Student;
import Project1.model.Address.Address;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class StudentTest {
    Student student1 = new Student();
    Student student2 = new Student();
    
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void studentNotNullTest_ShouldNotBeNull() {
        assertNotNull("should not be null", student1);
    }
    
    @Test
    public void sameStudentReferenceTest_ObjectsShouldBeSame() {
        assertSame(student1, student1);
    }
    
    @Test
    public void studentsNotSameTest_ObjectsShouldNotBeSame() {
        assertNotSame(student1, new Student());
    }
    
    @Test
    public void studentsNotSameTest2_ObjectsShouldNotBeSame() {
        assertNotSame(student1, student2);
    }
    
    @Test
    public void studentsFiveParametersConstructorTest_ShouldNotBeNull() {
        assertNotNull("should not be null", new Student("Jan", "Kowalski", new Date(2010,5,15),
                new Address("Nowe Miasto", "Topolowa 58", "65-345"), "4a"));
    }
    
    @Test
    public void studentFiveParametersConstructorTest_AllElementsShouldBeSame() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2010-05-15");
        Student student = new Student("Jan", "Kowalski", date,
                new Address("Nowe Miasto", "Topolowa 58", "65-345"), "4a");
        assertThat(student.getFirstName(), is("Jan"));
        assertThat(student.getLastName(), is("Kowalski"));
        assertThat(sdf.format( student.getBirthDate() ),
                is("2010-05-15") );
        assertThat(student.getAddress(), is(new Address("Nowe Miasto", "Topolowa 58", "65-345")));
        assertThat(student.getClassNumber(), is("4a"));
    }
    
    @Test
    public void studentSetFirstNameTest_ShouldEqual() {
        student1.setFirstName("Marcin");
        assertThat(student1.getFirstName(), is("Marcin"));
    }
    
    @Test
    public void studentSetLastNameTest_ShouldEqual() {
        student1.setLastName("Bielen");
        assertThat(student1.getLastName(), is("Bielen"));
    }
    
    @Test
    public void studentSetBirthDateTest_ShouldEqual() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1995-06-12");
        student1.setBirthDate(date);
        assertThat(sdf.format( student1.getBirthDate() ),
                is(sdf.format( date )));
    }
    
    @Test
    public void studentSetAddressTest_ShouldEqual() {
        student1.setAddress(new Address ("Warszawa", "Szewska 31/45", "01-123"));
        assertThat(student1.getAddress(), is(new Address ("Warszawa", "Szewska 31/45", "01-123")));
    }
    
    @Test
    public void studentSetClassNumberTest_ShouldEqual() {
        student1.setClassNumber("1");
        assertThat(student1.getClassNumber(), is("1"));
    }
    
    @Test
    public void studentArrayListTest_AllElementsShouldBeSame() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2010-05-15");
        Date date2 = sdf.parse("2010-11-09");
        Date date3 = sdf.parse("2010-01-28");
        ArrayList<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Sylwek", "Nowacki", date1,
                new Address("Nowe Miasto", "Topolowa 17", "65-345"), "4a"));
        listOfStudents.add(new Student("Felicja", "Wojciechowska", date2,
                new Address("Nowe Miasto", "Zelazna 123", "65-345"), "4a"));
        listOfStudents.add(new Student("Ula", "Szczepaniak", date3,
                new Address("Nowe Miasto", "Jableczna 40", "65-345"), "4a"));
        assertThat(listOfStudents.size(), is(3));
        assertThat(listOfStudents.get(0), is(new Student("Sylwek", "Nowacki", date1,
                new Address("Nowe Miasto", "Topolowa 17", "65-345"), "4a")));
        assertThat(listOfStudents.get(1), is(new Student("Felicja", "Wojciechowska", date2,
                new Address("Nowe Miasto", "Zelazna 123", "65-345"), "4a")));
        assertThat(listOfStudents.get(2), is(new Student("Ula", "Szczepaniak", date3,
                new Address("Nowe Miasto", "Jableczna 40", "65-345"), "4a")));
    }
}
