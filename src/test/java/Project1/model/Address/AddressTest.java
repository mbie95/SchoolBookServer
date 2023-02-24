package Project1.model.Address;

import Project1.model.Address.Address;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class AddressTest 
{
    Address address1 = new Address();
    
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addressDefaultConstructorTest_ShouldNotBeNull() {
        assertNotNull("should not be null", new Address());
    }
    
    @Test
    public void addressThreeParamConstructoTest_ShouldNotBeNull() {
        assertNotNull("should not be null", new Address("Nowe Miasto", "Topolowa 58", "65-345"));
    }
    
    @Test
    public void addressThreeParamConstructorTest_AllElementsShouldBeSame() {
        Address address = new Address("Nowe Miasto", "Topolowa 58", "65-345");
        assertThat(address.getCity(), is("Nowe Miasto"));
        assertThat(address.getStreetAndNumber(), is("Topolowa 58"));
        assertThat(address.getPostCode(), is("65-345"));
    }
    
    @Test
    public void addressSetCityTest_ShouldBeEqual(){
        address1.setCity("Warszawa");
        assertThat(address1.getCity(), is("Warszawa"));
    }
    
    @Test
    public void addressSetStreetAndNumberTest_ShouldBeEqual(){
        address1.setStreetAndNumber("Szewska 31/45");
        assertThat(address1.getStreetAndNumber(), is("Szewska 31/45"));
    }
    
    @Test
    public void addressSetPostCodeTest_ShouldBeEqual(){
        address1.setPostCode("01-123");
        assertThat(address1.getPostCode(), is("01-123"));
    }
}
