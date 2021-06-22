// IMPORTS
import java.io.*;
import java.net.*;

// CLASS
public class VentanaInformacionCliente extends Thread{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public boolean pausa;
    public boolean continuar;
    public boolean activo;

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
            startConnection("127.0.0.1", 8888);
            out.println(msg);
            String resp = in.readLine();
            stopConnection();
            return resp;
        }catch(Exception e){
            System.out.println("ERROR 8888: " + e);
            return "se dio un error";
        }
    }

    // run del thread
    public void run() {
        pausa = false;
        continuar = true;
        activo = true;
        System.out.println("Thread de VentanaInformacion iniciado");
        try {
            // thread functionality
            while (activo){
                String response = sendMessage("Hola VentanaInformacion soy ControladorServer");
                System.out.println(response);
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
}
