package Project1.model.Person;

//All tests passed. To check change Person class to not be abstract
/*
package Project1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class PersonTest {
    Person person1 = new Person();
    Person person2 = new Person();
    
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void personNotNullTest_ShouldNotBeNull() {
        assertNotNull("should not be null", person1);
    }
    
    @Test
    public void samePersonReferenceTest_ObjectsShouldBeSame() {
        assertSame(person1, person1);
    }
    
    @Test
    public void personsNotSameTest_ObjectsShouldNotBeSame() {
        assertNotSame(person1, new Person());
    }
    
    @Test
    public void personsNotSameTest2_ObjectsShouldNotBeSame() {
        assertNotSame(person1, person2);
    }
    
    @Test
    public void personFourParametersConstructorTest_ShouldNotBeNull() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2010-05-15");
        assertNotNull("should not be null", new Person("Jan", "Kowalski", date,
                new Address("Nowe Miasto", "Topolowa 58", "65-345")));
    }
    
    @Test
    public void personFourParametersConstructorTest_AllElementsShouldBeSame() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2010-05-15");
        Person person = new Person("Jan", "Kowalski", date,
                new Address("Nowe Miasto", "Topolowa 58", "65-345"));
        assertThat(person.getFirstName(), is("Jan"));
        assertThat(person.getLastName(), is("Kowalski"));
        assertThat(sdf.format( person.getBirthDate() ),
                is("2010-05-15"));
        assertThat(person.getAddress(), is(new Address("Nowe Miasto", "Topolowa 58", "65-345")));
    }
}
*/
