public class App {
    public static void main(String[] args) throws Exception {
        VuelosCliente client = new VuelosCliente();
        generarVuelos ListaVuelos = new generarVuelos();
        ListaVuelos.getVuelos();
        System.out.println("Los vuelos generados son: ");
        for (int i=0; i<ListaVuelos.getSize(); i++){
            System.out.println(ListaVuelos.getData(i));
        }

        while (true){
            String response = client.sendMessage(ListaVuelos.getData(0));
            System.out.println(response);
            if (response.equals("OK")){
                ListaVuelos.delete(0);
            }
            
        }
    }
}
