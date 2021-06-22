// IMPORTS
import java.io.*;
import java.net.*;

// CLASS
public class Controlador {
    public ServerSocket serverSocket;
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;

    public void start(int port) {
        try{
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String msg = in.readLine();
            System.out.println(msg);
            if ("Hola controlador".equals(msg)) {
                out.println("hello vuelos");
            }
            else {
                out.println("unrecognised greeting");
            }
        }catch(Exception e){System.out.println("ERROR: " + e);}
        
    }

    public void stop() {
        try{
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }catch(Exception e){System.out.println("ERROR: " + e);}
    }
    
}
