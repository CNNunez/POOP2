//import org.graalvm.compiler.phases.verify.VerifyInstanceOfUsage;

public class App {
    public static void main(String[] args) {
        VControlador ControladorWindow = new VControlador();
        ControladorServer ControladorServer = new ControladorServer("Thread_Controlador", ControladorWindow);
        ControladorWindow.setControlador(ControladorServer);
        ControladorServer.start();

        VentanaInformacionCliente VentanaInformacionCliente = new VentanaInformacionCliente();
        VentanaInformacionCliente.start();
    }
}
