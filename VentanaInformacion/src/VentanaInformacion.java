// IMPORTS
import java.io.*;
import java.net.*;

// CLASS
public class VentanaInformacion {
    public ServerSocket serverSocket;
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;

    public boolean pausa;
    public boolean continuar;
    public boolean activo;

    public void starter(){
        try{
            serverSocket = new ServerSocket(8888);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String msg = in.readLine();
            System.out.println(msg);
            
            if (msg.equals("Hola VentanaInformacion soy ControladorServer")) {
                ControladorServerRequest(out);
            }
            else {
                out.println("unrecognised info");
            }
            
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        }catch(Exception e){System.out.println("ERROR: " + e);}
        
    }


    // metodos de request
    public void ControladorServerRequest(PrintWriter out){
        out.println("Hola ControladorServer soy VentanaInformacion");
    }
}
