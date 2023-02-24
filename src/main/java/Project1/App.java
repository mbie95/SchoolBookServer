package Project1;

import Project1.server.Server;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    //Aplication is starting, server is created
    public static void main( String[] args ) throws ClassNotFoundException, ParseException, IOException, SQLException
    {
        System.out.println(greetings( "Server is starting!" ));
        new Server().startServer();   
    }
    
    public static String greetings(String message) {
        return message;
    }
}
