// IMPORTS
import java.io.*;
import java.net.*;

// CLASS
public class VentanaControlador{
    public ServerSocket serverSocket;
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;

    public String[] Pistas;
    public String[] Puertas;

    VentanaControlador(){
        String listaPistas = "G-1,G-2,G-3,G-4,G-5,M-1,M-2,M-3,M-4,M-5,P-1,P-2,P-1¿3,P-4,P-5";
        Pistas = listaPistas.split(",");

        String listaPuertas = "p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20";
        Puertas = listaPuertas.split(",");
    }

    public void starter(){
        try{
            serverSocket = new ServerSocket(7777);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String msg = in.readLine();
            System.out.println(msg);
            
            if (msg.equals("Hola VentanaControlador soy ControladorServer")) {
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
        out.println("Hola controladorServer soy VentanaControlador");
    }
}
