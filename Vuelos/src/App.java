public class App {
    public static void main(String[] args) throws Exception {
        VVuelos VuelosWindow = new VVuelos();
        VuelosCliente client = new VuelosCliente(VuelosWindow);
        generarVuelos ListaVuelos = new generarVuelos();
        ListaVuelos.getVuelos();
        System.out.println("Los vuelos generados son: ");
        for (int i=0; i<ListaVuelos.getSize(); i++){
            System.out.println(ListaVuelos.getData(i));
        }

        for (int i=0; i<15; i++){
            String response = client.sendMessage(ListaVuelos.getData(i));
            System.out.println(response);
            
        }
    }
}
