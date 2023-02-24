package Project1.model.Person.Teacher;

import Project1.model.Address.Address;
import Project1.model.Person.Teacher.Teacher;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author marcin
 */
public class TeacherTest {
    Teacher teacher1 = new Teacher();
    Teacher teacher2 = new Teacher();
    
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void teacherNotNullTest_ShouldNotBeNull() {
        assertNotNull("should not be null", teacher1);
    }
    
    @Test
    public void sameTeacherReferenceTest_ObjectsShouldBeSame() {
        assertSame(teacher1, teacher1);
    }
    
    @Test
    public void teachersNotSameTest_ObjectsShouldNotBeSame() {
        assertNotSame(teacher1, new Teacher());
    }
    
    @Test
    public void teachersNotSameTest2_ObjectsShouldNotBeSame() {
        assertNotSame(teacher1, teacher2);
    }
    
    @Test
    public void teachersFiveParametersConstructorTest_ShouldNotBeNull() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2010-05-15");
        assertNotNull("should not be null", new Teacher("Jan", "Kowalski", date,
                new Address("Nowe Miasto", "Topolowa 58", "65-345")));
    }
    
    @Test
    public void teacherFiveParametersConstructorTest_AllElementsShouldBeSame() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2010-05-15");
        Teacher teacher = new Teacher("Jan", "Kowalski", date,
                new Address("Nowe Miasto", "Topolowa 58", "65-345"));
        assertThat(teacher.getFirstName(), is("Jan"));
        assertThat(teacher.getLastName(), is("Kowalski"));
        assertThat(sdf.format( teacher.getBirthDate() ),
                is("2010-05-15"));
        assertThat(teacher.getAddress(), is(new Address("Nowe Miasto", "Topolowa 58", "65-345")));
    }
    
    @Test
    public void teacherSetFirstNameTest_ShouldEqual(){
        teacher1.setFirstName("Marcin");
        assertThat(teacher1.getFirstName(), is("Marcin"));
    }
    
    @Test
    public void teacherSetLastNameTest_ShouldEqual(){
        teacher1.setLastName("Bielen");
        assertThat(teacher1.getLastName(), is("Bielen"));
    }
    
    @Test
    public void teacherSetBirthDateTest_ShouldEqual() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1995-06-12");
        teacher1.setBirthDate(date);
        assertThat(sdf.format( teacher1.getBirthDate() ),
                is("1995-06-12"));
    }
    
    @Test
    public void teacherSetAddressTest_ShouldEqual(){
        teacher1.setAddress(new Address ("Warszawa", "Szewska 31/45", "01-123"));
        assertThat(teacher1.getAddress(), is(new Address ("Warszawa", "Szewska 31/45", "01-123")));
    }
}
