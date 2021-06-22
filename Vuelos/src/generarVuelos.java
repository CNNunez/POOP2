import java.util.*;
import java.util.concurrent.locks.Condition;

public class generarVuelos {
    ArrayList<vuelo> ListaVuelos;
    ArrayList<String> ListaSizes;
    ArrayList<String> ListaCondition;
    int caso, tamano, cantVuelos, condition;
    vuelo newVuelo;
    generarVuelos(){
        ListaSizes = new ArrayList<String>();
        ListaSizes.add(0,"pequeno");
        ListaSizes.add(1,"mediano");
        ListaSizes.add(2,"grande");
        
        ListaCondition = new ArrayList<String>();
        ListaCondition.add(0,"atiempo");
        ListaCondition.add(1,"retraso");

        cantVuelos = 15;
    }

    public ArrayList<vuelo> getVuelos(){
        ListaVuelos = new ArrayList<>();
        Random rd1 = new Random();
        Random rd2 = new Random();
        Random rd3 = new Random();
        for (int i=0; i<cantVuelos; i++){
            caso = rd1.nextInt(2 + 1);
            tamano = rd2.nextInt(2 + 1);
            condition = rd3.nextInt(1 + 1);
            switch (caso){
                case 0:
                    avion newCarga = new carga(ListaSizes.get(tamano), ListaCondition.get(condition));
                    newVuelo = new vuelo(newCarga,"","");
                    ListaVuelos.add(ListaVuelos.size(), newVuelo);
                    break;
                case 1:
                    avion newPasajero = new pasajeros(ListaSizes.get(tamano), ListaCondition.get(condition));
                    newVuelo = new vuelo(newPasajero,"","");
                    ListaVuelos.add(ListaVuelos.size(), newVuelo);
                    break;
                case 2:
                    avion newPrivado = new privado(ListaSizes.get(tamano), ListaCondition.get(condition));
                    newVuelo = new vuelo(newPrivado,"","");
                    ListaVuelos.add(ListaVuelos.size(), newVuelo);
                    break;
            }
        }
        return ListaVuelos;
    }

    public int getSize(){
        return ListaVuelos.size();
    }

    public String getData(int index){
        String data = "";
        data = data + ListaVuelos.get(index).Avion.getClass() + ";";
        data = data + ListaVuelos.get(index).getSize() + ";";
        data = data + ListaVuelos.get(index).getCondicion() + ";";
        return data;
    }

    public void delete(int index){
        ListaVuelos.remove(index);
    }
}
