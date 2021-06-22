public class App {
    public static void main(String[] args) throws Exception {
        VuelosCliente client = new VuelosCliente();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("Hola controlador soy vuelos");
        System.out.println(response);
    }
}
