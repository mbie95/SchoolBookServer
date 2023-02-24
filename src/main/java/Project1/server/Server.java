package Project1.server;

import Project1.logic.Service;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 *
 * @author marcin
 */
public class Server {
    private Socket connectionSocket;
        
    //function runs server
    public void startServer() throws IOException, ClassNotFoundException, SQLException {
        ServerSocket serverSocket = new ServerSocket(9876);
        Service service = new Service();
        boolean serverRunning = true;
        
        //io transmission
        while(serverRunning) {
            try {
                connectionSocket = serverSocket.accept();
                new RequestHandler(connectionSocket, service).start();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try { 
            serverSocket.close(); 
        } catch (Exception exc) {}
    }
    
}
