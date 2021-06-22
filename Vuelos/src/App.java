public class App {
    public static void main(String[] args) throws Exception {
        Vuelos client = new Vuelos();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("Hola controlador");
        System.out.println(response);
    }
}
