// IMPORTS
import java.io.*;
import java.net.*;
import java.util.*;

// CLASS
public class VentanaControlador{
    public ServerSocket serverSocket;
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;

    ArrayList<String> Pistas;
    ArrayList<String> Puertas;

    VentanaControlador(){
        String listaPistas = "G-1,G-2,G-3,G-4,G-5,M-1,M-2,M-3,M-4,M-5,P-1,P-2,P-1¿3,P-4,P-5";
        Pistas = new ArrayList<String>(Arrays.asList(listaPistas.split(",")));

        String listaPuertas = "p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20";
        Puertas = new ArrayList<String>(Arrays.asList(listaPuertas.split(",")));
        
    }

    public void starter(){
        try{
            System.out.println("in");
            serverSocket = new ServerSocket(7777);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String msg = in.readLine();
            System.out.println("msg: " + msg);
            
            if (msg.equals("getPistaG")) {
                PistaGRequest(out);
            }
            else if (msg.equals("getPuertaM")) {
                PistaMRequest(out);
            }
            else if (msg.equals("getPuertaP")) {
                PistaPRequest(out);
            }
            else {
                if (msg.contains("-")){
                    Pistas.add(msg);
                }
                else {
                    Puertas.add(msg);
                }
                out.println("");
            }
            
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        }catch(Exception e){System.out.println("ERROR: " + e);}
        
    }


    // metodos de request
    public void PistaGRequest(PrintWriter out){
        boolean send = false;
        for (int i=0; i<Pistas.size(); i++){
            if (Pistas.get(0).contains("G")){
                out.println(Pistas.get(0));
                Pistas.remove(0);
                send = true;
            }
        }
        if (!send){
            out.println("");
        }
    }
    public void PistaMRequest(PrintWriter out){
        boolean send = false;
        for (int i=0; i<Pistas.size(); i++){
            if (Pistas.get(0).contains("M")){
                out.println(Pistas.get(0));
                Pistas.remove(0);
                send = true;
            }
        }
        if (!send){
            out.println("");
        }
    }
    public void PistaPRequest(PrintWriter out){
        boolean send = false;
        for (int i=0; i<Pistas.size(); i++){
            if (Pistas.get(0).contains("P")){
                out.println(Pistas.get(0));
                Pistas.remove(0);
                send = true;
            }
        }
        if (!send){
            out.println("");
        }
    }
    public void PuertaRequest(PrintWriter out){
        out.println(Puertas.get(0));
        Puertas.remove(0);
    }
}
