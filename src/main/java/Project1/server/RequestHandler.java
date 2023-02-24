package Project1.server;

import Project1.logic.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author marcin
 */
public class RequestHandler extends Thread {
    private Socket connectionSocket;
    private Service service;
    private BufferedReader buffer;
    private PrintWriter serverPrintOut;
    private final Lock lock = new ReentrantLock();

    public RequestHandler(Socket connectionSocket, Service service) {
        this.connectionSocket = connectionSocket;
        this.service = service;
    }
    
    public void run() {
        try {
            buffer = new BufferedReader(
                    new InputStreamReader(
                            connectionSocket.getInputStream()));
            serverPrintOut = new PrintWriter(connectionSocket.getOutputStream(), true);

            serverPrintOut.println("Connection was successful!");

            String line;
            //reading requests, sending them to service, making responses
            while (!(line = buffer.readLine()).equals("END;")) {
                lock.lock();
                try {
                    String response = service.request(line);
                    serverPrintOut.println(response);
                } catch (ClassNotFoundException ex) {
                    throw new Error("Problem", ex);
                } catch (SQLException ex) {
                    throw new Error("Problem", ex);
                } finally {
                    lock.unlock();
                }

            }
            
        } catch (IOException ex) {
            throw new Error("Problem", ex);
        } finally {
            try {
              connectionSocket.close();
              connectionSocket = null;
            } catch (Exception ex) { 
                throw new Error("Problem", ex);
            }
        }
    }
}
