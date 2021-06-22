// IMPORTS
import java.io.*;
import java.net.*;
import java.util.*;

// CLASS
public class VentanaControladorCliente extends Thread{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public boolean pausa;
    public boolean continuar;
    public boolean activo;

    ArrayList<vuelo> ListaVuelos;
    ArrayList<vuelo> ListaAterrizando;

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
            startConnection("127.0.0.1", 7777);
            out.println(msg);
            String resp = in.readLine();
            in.close();
            out.close();
            clientSocket.close();
            return resp;
        }catch(Exception e){
            System.out.println("ERROR 7777: " + e);
            return "se dio un error";
        }
    }

    // run del thread
    public void run() {
        ListaVuelos = new ArrayList<vuelo>();
        ListaAterrizando = new ArrayList<vuelo>();
        pausa = false;
        continuar = true;
        activo = true;
        System.out.println("Thread de VentanaControlador iniciado");
        try {
            // thread functionality
            while (activo){
                getPista();
                System.out.println("Lista de vuelos:");
                printList(ListaVuelos);
                System.out.println("");
                System.out.println("Lista de Aterrizando:");
                printList(ListaAterrizando);
                while (pausa){
                    System.out.println("Controlador en pausa");
                }
                Thread.sleep(10000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread de controlador finalizado");
    }

    public void addToListaVuelos(int size, vuelo newVuelo){
        ListaVuelos.add(size, newVuelo);
    }

    public void getPista(){
        if (ListaVuelos!=null){
            if (ListaVuelos.get(0).Avion.Size.equals("pequeno")){
                String response = sendMessage("getPistaP");
                if (!response.equals("")){
                    ListaVuelos.get(0).Pista = response;
                    ListaAterrizando.add(ListaAterrizando.size(), ListaVuelos.get(0));
                    ListaVuelos.remove(0);
                }
            }
            else if (ListaVuelos.get(0).Avion.Size.equals("mediano")){
                String response = sendMessage("getPistaM");
                if (!response.equals("")){
                    ListaVuelos.get(0).Pista = response;
                    ListaAterrizando.add(ListaAterrizando.size(), ListaVuelos.get(0));
                    ListaVuelos.remove(0);
                }
            }
            else if (ListaVuelos.get(0).Avion.Size.equals("grande")){
                String response = sendMessage("getPistaG");
                if (!response.equals("")){
                    ListaVuelos.get(0).Pista = response;
                    ListaAterrizando.add(ListaAterrizando.size(), ListaVuelos.get(0));
                    ListaVuelos.remove(0);
                }
            }
        }
    }

    public void printList(ArrayList<vuelo> list){
        for (int i=0; i<list.size(); i++){
            String data = "";
            data = data + ListaVuelos.get(i).Avion.getClass() + ";";
            data = data + ListaVuelos.get(i).getSize() + ";";
            data = data + ListaVuelos.get(i).getCondicion() + ";";
            data = data + ListaVuelos.get(i).getPista() + ";";
            data = data + ListaVuelos.get(i).getPuerta();
            System.out.println(data);
        }
    }

}
