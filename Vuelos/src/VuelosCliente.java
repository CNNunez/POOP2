// IMPORTS
import java.io.*;
import java.net.*;

// CLASS
public class VuelosCliente {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try{
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }catch(Exception e){System.out.println("ERROR: " + e);}
    }

    public void stopConnection() {
        try{
            in.close();
            out.close();
            clientSocket.close();
        }catch(Exception e){System.out.println("ERROR: " + e);}
    }
    
    public String sendMessage(String msg) {
        try{
            startConnection("127.0.0.1", 6666);
            out.println(msg);
            String resp = in.readLine();
            stopConnection();
            return resp;
        }catch(Exception e){
            System.out.println("ERROR: " + e);
            return "se dio un error";
        }
    }

}
