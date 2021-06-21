public class vuelo extends avion{
    // atributos
    avion Avion;
    String Pista;

    //constructores
    vuelo(){
        Avion = new avion();
        Pista = "";
    }

    vuelo(avion newAvion, String newPista){
        Avion = newAvion;
        Pista = newPista;
    }

    // métodos
}
