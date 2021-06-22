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
    //ArrayList<vuelo> ListaAterrizando;
    ArrayList<vuelo> ListaMoving;
    ArrayList<vuelo> ListaPuerta;
    VControlador V;
    VentanaControladorCliente VentanaControladorCliente;

    public ControladorServer(String name, VControlador ControladorWindow) {
        super(name);
        ListaVuelos = new ArrayList<>();
        V = ControladorWindow;
        VentanaControladorCliente = new VentanaControladorCliente();
    }

    public void starter(int port) throws InterruptedException{
        try{
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String msg = in.readLine();
            System.out.println(msg);

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

            VuelosRequest(out, msg);

        }catch(Exception e){System.out.println("ERROR" + port + ": " + e);}
        
    }

    // run del thread
    public void run() {
        pausa = false;
        continuar = true;
        activo = true;
        System.out.println("Thread de controlador iniciado");
        VentanaControladorCliente.start();
        try {
            // thread functionality
            while (activo){
                starter(6666);
                while (pausa){
                    System.out.println("Controlador en pausa");
                    Thread.sleep(2000);
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

        if (datos[0].equals("class carga")){
            avion newCarga = new carga(datos[1], datos[2]);
            vuelo newVuelo = new vuelo(newCarga,"","");
            ListaVuelos.add(ListaVuelos.size(), newVuelo);
            printData(ListaVuelos.size()-1);
            VentanaControladorCliente.addToListaVuelos(ListaVuelos.size(), newVuelo);
        }
        else if (datos[0].equals("class pasajeros")){
            avion newPasajeros = new pasajeros(datos[1], datos[2]);
            vuelo newVuelo = new vuelo(newPasajeros,"","");
            ListaVuelos.add(ListaVuelos.size(), newVuelo);
            printData(ListaVuelos.size()-1);
            VentanaControladorCliente.addToListaVuelos(ListaVuelos.size(), newVuelo);
        }
        else if (datos[0].equals("class privado")){
            avion newPrivado = new privado(datos[1], datos[2]);
            vuelo newVuelo = new vuelo(newPrivado,"","");
            ListaVuelos.add(ListaVuelos.size(), newVuelo);
            printData(ListaVuelos.size()-1);
            VentanaControladorCliente.addToListaVuelos(ListaVuelos.size(), newVuelo);
        }
        else{System.out.println("ERROR: no se reconoce la clase del avion.");}
    }

    public void printData(int index){
        String data = "";
        data = data + ListaVuelos.get(index).Avion.getClass() + ";";
        data = data + ListaVuelos.get(index).getSize() + ";";
        data = data + ListaVuelos.get(index).getCondicion() + ";";
        data = data + ListaVuelos.get(index).getPista() + ";";
        data = data + ListaVuelos.get(index).getPuerta() + ";";
        data = data + "\n";
        V.textAreaControlador.append(data);
    }

    
}
