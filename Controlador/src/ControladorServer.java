// IMPORTS
import java.io.*;
import java.net.*;
import java.util.*;

// CLASS
public class ControladorServer extends Thread{
    public ServerSocket serverSocket;
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;

    public boolean pausa;
    public boolean continuar;
    public boolean activo;

    ArrayList<vuelo> ListaVuelos;

    public ControladorServer(String name) {
        super(name);
        ListaVuelos = new ArrayList<>();
    }

    public void starter(int port) throws InterruptedException{
        try{
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String msg = in.readLine();
            System.out.println(msg);
            VuelosRequest(out, msg);

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        }catch(Exception e){System.out.println("ERROR: " + e);}
        
    }

    // run del thread
    public void run() {
        pausa = false;
        continuar = true;
        activo = true;
        System.out.println("Thread de controlador iniciado");
        try {
            // thread functionality
            while (activo){
                starter(6666);
                while (pausa){
                    System.out.println("Controlador en pausa");
                }
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread de controlador finalizado");
    }


    // metodos de request
    public void VuelosRequest(PrintWriter out, String msg) throws InterruptedException{
        out.println("OK");
        String[] datos = msg.trim().split(";");

        if (datos[0].equals("classcarga")){
            avion newCarga = new carga(datos[1], datos[2]);
            vuelo newVuelo = new vuelo(newCarga,"","");
            ListaVuelos.add(ListaVuelos.size(), newVuelo);
        }
        else if (datos[0].equals("classpasajeros")){
            avion newPasajeros = new pasajeros(datos[1], datos[2]);
            vuelo newVuelo = new vuelo(newPasajeros,"","");
            ListaVuelos.add(ListaVuelos.size(), newVuelo);
        }
        else if (datos[0].equals("classprivado")){
            avion newPrivado = new privado(datos[1], datos[2]);
            vuelo newVuelo = new vuelo(newPrivado,"","");
            ListaVuelos.add(ListaVuelos.size(), newVuelo);
        }
        else{System.out.println("ERROR: no se reconoce la clase del avion.");}
    }

}
