package Project1.model.Grade;

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
public class GradeTest {
    Grade grade1 = new Grade();
    Grade grade2 = new Grade();
    
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void gradeNotNullTest_ShouldNotBeNull() {
        assertNotNull("should not be null", grade1);
    }
    
    @Test
    public void sameGradeReferenceTest_ObjectsShouldBeSame() {
        assertSame(grade1, grade1);
    }
    
    @Test
    public void gradesNotSameTest_ObjectsShouldNotBeSame() {
        assertNotSame(grade1, new Grade());
    }
    
    @Test
    public void gradesNotSameTest2_ObjectsShouldNotBeSame() {
        assertNotSame(grade1, grade2);
    }
    
    @Test
    public void gradeThreeParamConstructorTest_AllElementsShouldBeSame() {
        Grade grade = new Grade(1453, 18, 6);
        assertThat(grade.getIdStudent(), is(1453));
        assertThat(grade.getIdSubject(), is(18));
        assertThat(grade.getGrade(), is(6));
    }
    
    @Test
    public void gradeSetIdStudentTest_ShouldBeEqual(){
        grade1.setIdStudent(4235);
        assertThat(grade1.getIdStudent(), is(4235));
    }
    
    @Test
    public void gradeSetIdSubjectTest_ShouldBeEqual(){
        grade1.setIdSubject(23);
        assertThat(grade1.getIdSubject(), is(23));
    }
    
    @Test
    public void gradeSetGradeTest_ShouldBeEqual(){
        grade1.setGrade(4);
        assertThat(grade1.getGrade(), is(4));
    }
}
