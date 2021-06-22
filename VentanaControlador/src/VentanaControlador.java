// IMPORTS
import java.io.*;
import java.net.*;

// CLASS
public class VentanaControlador extends Thread{
    public ServerSocket serverSocket;
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;

    public boolean pausa;
    public boolean continuar;
    public boolean activo;

    public VentanaControlador(String name) {
        super(name);
    }

    public void starter(int port) throws InterruptedException{
        try{
            serverSocket = new ServerSocket(port);
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

    // run del thread
    public void run() {
        pausa = false;
        continuar = true;
        activo = true;
        System.out.println("Thread de controlador iniciado");
        try {
            // thread functionality
            while (activo){
                starter(7777);
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
    public void ControladorServerRequest(PrintWriter out) throws InterruptedException{
        out.println("hello controladorServer soy VentanaControlador");
        Thread.sleep(10000);
    }
}
