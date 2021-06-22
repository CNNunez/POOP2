// IMPORTS
import java.io.*;
import java.net.*;
import java.util.*;

// CLASS
public class ThreadAterrizaje extends Thread{
    vuelo Vuelo;

    ThreadAterrizaje(vuelo newVuelo){
        Vuelo = newVuelo;
    }
    // run del thread
    public void run() {
        try {
            System.out.println("Vuelo aterrizando en la pista: " + Vuelo.getPista());
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
